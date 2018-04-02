package com.servinglynk.hmis.warehouse.base.service.impl;

import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_DISABLED;
import static com.servinglynk.hmis.warehouse.common.Constants.ACCOUNT_STATUS_PENDING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.PasswordResetService;
import com.servinglynk.hmis.warehouse.client.notificationservice.NotificationServiceClient;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;
import com.servinglynk.hmis.warehouse.core.model.Notification;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;

public class PasswordResetServiceImpl extends ServiceBase implements PasswordResetService {
	
	@Autowired
	NotificationServiceClient notificationServiceClient;

	
	@Transactional
	public void createPasswordReset(String username, String auditUser,
			String redirectURL) {
		if (!ValidationUtil.isValidEmail(username)) {
			throw new InvalidParameterException("invalid username: " + username);
		}
		
		// get user account
		HmisUser pAccount = daoFactory.getAccountDao().findByUsername(username);
		
		if(pAccount==null)
				throw new AccountNotFoundException("Account not found with username "+ username);

		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_PENDING)) {
			pAccount.setStatus(Constants.ACCOUNT_STATUS_ACTIVE);
//			throw new AccountPendingException();
		}

		if (pAccount.getStatus().equalsIgnoreCase(ACCOUNT_STATUS_DISABLED)) {
			throw new AccountDisabledException();
		}

		String newPassword =GeneralUtil.randomPassword();
		pAccount.setPassword(HMISCryptographer.Encrypt(newPassword));
		
/*		// Make new verification object
		VerificationEntity pVerification = new VerificationEntity();
		pVerification.setToken(GeneralUtil.getUniqueToken(64));
		pVerification.setType(VERIFICATION_TYPE_PASSWORD_RESET);
        pVerification.setCreatedBy(auditUser);
        pVerification.setCreatedAt(new Date());

        pVerification = daoFactory.getVerificationDao().create(pVerification);


		// create password-reset object
		PasswordResetEntity pPasswordReset = new PasswordResetEntity();
		pPasswordReset.setAccount(pAccount);
		pPasswordReset.setVerification(pVerification);
		pPasswordReset.setStatus(PASSWORD_RESET_STATUS_CREATED);
		pPasswordReset.setCreatedBy(auditUser);
		pPasswordReset.setCreatedAt(new Date());
		

		// persist the password-reset object....
		daoFactory.getPasswordResetDao().create(pPasswordReset);
*/

		daoFactory.getAccountDao().updateAccount(pAccount);
		
		Notification notification = new Notification();
		notification.setMethod("EMAIL");
		notification.setType("HMIS_USER_PASSWORD_RESET");
		notification.getParameters().addParameter(new Parameter("name",pAccount.getFirstName()+" "+pAccount.getLastName()));
		notification.getParameters().addParameter(new Parameter("password",newPassword));
		notification.getRecipients().addToRecipient(pAccount.getEmailAddress());
		notificationServiceClient.createNotification(notification);
	}


}
