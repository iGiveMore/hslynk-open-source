package com.servinglynk.hmis.warehouse.base.service.impl;


import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_ACTIVE;
import static com.servinglynk.hmis.warehouse.common.Constants.PASSWORD_RESET_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.PASSWORD_RESET_STATUS_CREATED;
import static com.servinglynk.hmis.warehouse.common.Constants.PASSWORD_RESET_STATUS_REJECTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_REJECTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_PASSWORD_RESET;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_USERNAME_CHANGE;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.VerificationService;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.VerificationConverter;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.base.AccountDataChangeEntity;
import com.servinglynk.hmis.warehouse.model.base.AccountLockoutEntity;
import com.servinglynk.hmis.warehouse.model.base.PasswordResetEntity;
import com.servinglynk.hmis.warehouse.model.base.VerificationEntity;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AlreadyVerifiedException;
import com.servinglynk.hmis.warehouse.service.exception.VerificationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.VerificationStatusAlreadyUpdatedException;
import com.servinglynk.hmis.warehouse.service.exception.VerificationTargetNotFoundException;

public class VerificationServiceImpl extends ServiceBase implements
		VerificationService {
	
	
	@Autowired
	public ValidationBean validationBean;

	
	@Autowired
	public NotificationServiceClient notificationServiceClient;
	
	@Transactional
	public Account getAccountByVerfication(Verification verification) {
		VerificationEntity pVerification = daoFactory.getVerificationDao().findByToken(verification.getToken());
		if(pVerification==null) throw new VerificationNotFoundException("Invalid verification code. Please contact your administrator.");
		com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = daoFactory.getAccountDao().findByVerificationId(pVerification.getId());

		return AccountConverter.convertToAccount(pAccount);
	}

	 @Transactional
	public Verification updateVerificationStatus(Verification verification,
			String auditServiceName) throws MissingParameterException, InvalidParameterException,
			VerificationNotFoundException, VerificationStatusAlreadyUpdatedException {
		
		
		String status = verification.getStatus();
		if (ValidationUtil.isEmpty(status)) {
			throw new MissingParameterException("status is required.");
		}
		if (!(status.equalsIgnoreCase(VERIFICATION_STATUS_ACCEPTED) || status.equalsIgnoreCase(VERIFICATION_STATUS_REJECTED))) {
			throw new InvalidParameterException("invalid status: " + status);
		}

		// retrieve the verification from the database using the token
		VerificationEntity pVerification = daoFactory.getVerificationDao().findByToken(verification.getToken());
		// if there is no verification record found, throw an exception
		if (pVerification == null) {
			throw new VerificationNotFoundException("Invalid verification code. Please contact your administrator.");
		}
		// if the status of the verification is already ACCEPTED or REJECTED, throw an exception
		if (pVerification.isStatusAcceptedOrRejected()) {
			throw new VerificationStatusAlreadyUpdatedException();
		}
		
		pVerification.setStatus(status.toUpperCase());
		pVerification.setModifiedAt(new Date());
		pVerification.setModifiedBy(auditServiceName);
		// update the verification
		daoFactory.getVerificationDao().updateVerification(pVerification);
		
		if (pVerification.isStatusAccepted()) {
			if (pVerification.getType().equalsIgnoreCase(VERIFICATION_TYPE_ACCOUNT_CREATION)) {
				com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = daoFactory.getAccountDao().findByVerificationId(pVerification.getId());
				pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
				pAccount.setModifiedAt(new Date());
				pAccount.setModifiedBy(auditServiceName);
				daoFactory.getAccountDao().updateAccount(pAccount);
				Notification notification = new Notification();
				notification.setMethod("EMAIL");
				notification.setType("HMIS_ACCOUNT_ACTIVATED");
				if(pAccount.getProjectGroupEntity()!=null)	
					notification.setSender(pAccount.getProjectGroupEntity().getSenderEmail());
				notification.getParameters().addParameter(new Parameter("name", pAccount.getFirstName()+" "+pAccount.getLastName()));
				notification.getRecipients().addToRecipient(pAccount.getEmailAddress());
				notificationServiceClient.createNotification(notification);
			} else if (pVerification.getType().equalsIgnoreCase(VERIFICATION_TYPE_PASSWORD_RESET)) {
				
				String password = null;

				List<Parameter> paramList = verification.getParameters();
				for (Parameter param : paramList) {
					if (param.getKey().equalsIgnoreCase("password")){
						password = param.getKey();
					}
                }
				//throw missing parameter exception

				if (ValidationUtil.isEmpty(password)){
					throw new MissingParameterException("Password is empty");
				}
				
				if (!ValidationUtil.isValidPassword(password)) {
					throw new InvalidParameterException("Password should contain only alpha numeric characters");
				}
				
				if (!ValidationUtil.isValidMinLen(password, new Integer(validationBean.getPwMinLength()))) {
					throw new InvalidParameterException("Password needs to be minium of 6 characters");
				}
				
				if (!ValidationUtil.isValidMaxLen(password, new Integer(validationBean.getPwMaxLength()))) {
					throw new InvalidParameterException("Password cannot contain more than than 256 characters");
				}
				
				PasswordResetEntity pPasswordReset = daoFactory.getPasswordResetDao().findByVerificationId(pVerification.getId());
				pPasswordReset.setStatus(PASSWORD_RESET_STATUS_ACCEPTED);
				pPasswordReset.setPassword(HMISCryptographer.Encrypt(password));
				pPasswordReset.setModifiedAt(new Date());
				pPasswordReset.setModifiedBy(auditServiceName);
				daoFactory.getPasswordResetDao().updatePasswordReset(pPasswordReset);

				com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = pPasswordReset.getAccount();
				pAccount.setPassword(HMISCryptographer.Encrypt(password));
				pAccount.setModifiedAt(new Date());
				pAccount.setModifiedBy(auditServiceName);
				daoFactory.getAccountDao().updateAccount(pAccount);
				
/*				AccountLockoutEntity pLockout = pAccount.getAccountLockout();
				if(pLockout!=null){
					pLockout.setFailureCount(0);
					pLockout.setLastLoginStatus(1);
					pLockout.setModifiedBy(auditServiceName);
					pPasswordReset.setModifiedAt(Calendar.getInstance().getTime());
					pLockout.setLastAttemptAt(Calendar.getInstance().getTime());
					pAccount.setAccountLockout(pLockout);
					pLockout.setAccount(pAccount);
					daoFactory.getAccountDao().updateAccount(pAccount);
				}*/
				

				List<PasswordResetEntity> pPasswordResetList=null; 
				pPasswordResetList= daoFactory.getPasswordResetDao().findByAccountIdAndStatus(pAccount.getId(), PASSWORD_RESET_STATUS_CREATED);
				for (PasswordResetEntity pPWDReset:  pPasswordResetList) {
					Verification v = new Verification();
					v.setStatus(VERIFICATION_STATUS_REJECTED);
					v.setToken(pPWDReset.getVerification().getToken());
					v.setType(VERIFICATION_TYPE_PASSWORD_RESET);

					updateVerificationStatus(v, auditServiceName);
				}
				
			} else if (pVerification.getType().equalsIgnoreCase(VERIFICATION_TYPE_USERNAME_CHANGE)) {
								
				//get AccountDataChange object
				AccountDataChangeEntity accountDataChange = daoFactory.getAccountDataChangeDao().getAccountDataChangeByVerificationId(pVerification.getId());
				//get new username
				String newUsername = accountDataChange.getNewUsername();
				//get account	
				com.servinglynk.hmis.warehouse.model.base.HmisUser account = accountDataChange.getAccount();
				//change username
				account.setUsername(newUsername);
				//change account status
				account.setStatus(ACCOUNT_STATUS_ACTIVE);
				account.setModifiedAt(new Date());
				account.setModifiedBy(auditServiceName);
				
				//update account
				daoFactory.getAccountDao().updateAccount(account);
				//send confirmation email to the old username

				
			}
			
		} else if (pVerification.isStatusRejected()) {
			if (pVerification.getType().equalsIgnoreCase(VERIFICATION_TYPE_PASSWORD_RESET)) {
				PasswordResetEntity pPasswordReset = daoFactory.getPasswordResetDao().findByVerificationId(pVerification.getId());
				pPasswordReset.setStatus(PASSWORD_RESET_STATUS_REJECTED);
				pPasswordReset.setModifiedAt(new Date());
				pPasswordReset.setModifiedBy(auditServiceName);
				daoFactory.getPasswordResetDao().updatePasswordReset(pPasswordReset);
			}	
		}
		
		return VerificationConverter.convertToVerification(pVerification);
	}

	 @Transactional
	public void createVerification(Verification verification) throws AlreadyVerifiedException, AccountNotFoundException, VerificationTargetNotFoundException,
	MissingParameterException, InvalidParameterException {
		
		if (verification.getType() != null
				&& (verification.getType().equals(VERIFICATION_TYPE_ACCOUNT_CREATION))) {
			String username = verification.getParameter("username");
			if (username == null)
				throw new MissingParameterException("username is required");

			com.servinglynk.hmis.warehouse.model.base.HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);
			if (pAccount == null)
				throw new VerificationTargetNotFoundException("Verification Target  not found with user name "+username);

			if (pAccount.getStatus() != null && pAccount.getStatus().equals(ACCOUNT_STATUS_ACTIVE))
				throw new AlreadyVerifiedException();
			
			pAccount.setStatus(ACCOUNT_STATUS_ACTIVE);
			daoFactory.getAccountDao().updateAccount(pAccount);

		// Send notification
			
		} else {
			throw new InvalidParameterException();
		}


	}

}
