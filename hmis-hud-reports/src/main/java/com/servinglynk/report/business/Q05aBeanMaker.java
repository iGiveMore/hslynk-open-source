package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q05aBeanMaker extends BaseBeanMaker {
	private static Logger logger = Logger.getLogger(Q05aBeanMaker.class);
	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aBeanData(ReportData data){
		Q05aHMISComparableDBDataQualityDataBean bean = new Q05aHMISComparableDBDataQualityDataBean();
		if(data.isLiveMode()) {
		try {
			List<ClientModel> clients = data.getClients();
			List<EnrollmentModel>  enrollments = data.getEnrollments();
			List<String> enrollmentIds = new ArrayList<>();
			enrollments.forEach(enrollment -> {enrollmentIds.add(enrollment.getProjectEntryID());});
			data.setEnrollmentIds(enrollmentIds);
			List<EnrollmentModel> adults = enrollments.parallelStream().filter(enrollment-> enrollment.getAgeatentry() >= 18).collect(Collectors.toList());
			List<EnrollmentModel> children = enrollments.parallelStream().filter(enrollment-> enrollment.getAgeatentry() < 18 && enrollment.getAgeatentry() !=0 ).collect(Collectors.toList());
			List<EnrollmentModel> youthUnder25 = enrollments.parallelStream().filter(enrollment-> enrollment.getAgeatentry() >= 18 && enrollment.getAgeatentry() <= 24  && enrollment.getAgeatentry() !=0).collect(Collectors.toList());
			List<ClientModel> ageUnknown = clients.parallelStream().filter(enrollment-> enrollment.getAge() == 0).collect(Collectors.toList());
			
			List<EnrollmentModel> chronicHomeless = enrollments.parallelStream().filter(enrollment -> enrollment.isChronichomeless()).collect(Collectors.toList());
			data.setChronicHomeLess(chronicHomeless);
			List<ExitModel> exits = data.getExits();
			List<String> enrollmentsFromExit = new ArrayList<>();
		
			exits.forEach(exit -> { if(StringUtils.isNotEmpty(exit.getProjectEntryID())) { enrollmentsFromExit.add(exit.getProjectEntryID());} } );
			List<EnrollmentModel> leavers = enrollments.parallelStream().filter(enrollment -> enrollmentsFromExit.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			data.setLeavers(leavers);
			List<EnrollmentModel> adultLeavers = enrollments.parallelStream().filter(enrollment -> enrollmentsFromExit.contains(enrollment.getProjectEntryID()) && enrollment.getAgeatentry() > 18).collect(Collectors.toList());
			data.setAdultLeavers(adultLeavers);
			List<EnrollmentModel> activeClients = enrollments.parallelStream().filter(enrollment -> !enrollmentsFromExit.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			data.setActiveClients(activeClients);
			//select dedup_client_id from enrollment e, 
				
			/*String leaversQuery = "select  e.dedup_client_id ,e.age from %s.enrollment e join %s.project p  on (e.projectid = p.id %p ) "+
						" join  %s.exit ext  on  (ext.enrollmentid = e.id and ext.exitdate >= :startDate and ext.exitdate <= :endDate) "+
						" order by e.dedup_client_id";
				
		String stayersQuery = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p ) "+
						" join  %s.exit ext  on  (ext.enrollmentid = e.id and  e.entrydate <= :endDate and (ext.exitdate is null  or ext.exitdate > :endDate) ) "+
						" order by e.dedup_client_id ";
						*/
			
			List<EnrollmentModel> adultStayers = enrollments.parallelStream().filter(enrollment -> !enrollmentsFromExit.contains(enrollment.getProjectEntryID()) && enrollment.getAgeatentry() >= 18).collect(Collectors.toList());
			List<EnrollmentModel> adultStayersHoh365Days = adultStayers.parallelStream().filter(enrollment -> inProjectForMoreThan365Days(enrollment.getEntrydate()) && StringUtils.equals("1", enrollment.getRelationshiptohoh())).collect(Collectors.toList());
			data.setAdultStayersHoh365Days(adultStayersHoh365Days);
			List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
			List<EnrollmentModel> adultHohWithLeavers = adultLeavers.parallelStream().filter(enrollment -> StringUtils.equals("1", enrollment.getRelationshiptohoh()) && enrollment.getAgeatentry() >= 18).collect(Collectors.toList());
			data.setAdultStayers(adultStayers);
			data.setVeterans(veterans);
			List<EnrollmentModel> childHoh = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("1", enrollment.getRelationshiptohoh()) && enrollment.getAgeatentry() < 18 && enrollment.getAgeatentry() !=0).collect(Collectors.toList());
			List<EnrollmentModel> adultHoh = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("1", enrollment.getRelationshiptohoh()) && enrollment.getAgeatentry() >= 18).collect(Collectors.toList());
			data.setAdultHoh(adultHoh);
			int numberOfStayers = enrollments.size() - exits.size();
			bean.setTotNumOfPersonServed(BigInteger.valueOf(clients !=null ? clients.size() : 0));
			bean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
			bean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
			bean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(getSize(ageUnknown)));
			
			
			bean.setNoOfChildHeadsOfHousehold(BigInteger.valueOf(childHoh !=null ? childHoh.size() : 0));
			bean.setNoOfChronicallyHomelessPersons(BigInteger.valueOf(chronicHomeless !=null ? chronicHomeless.size() : 0));
			bean.setNoOfVeterans(BigInteger.valueOf(veterans !=null ? veterans.size() : 0));
			
			bean.setNumOfAdultandHeadOfHHLeavers(BigInteger.valueOf(adultHohWithLeavers !=null ? adultHohWithLeavers.size() : 0));
			bean.setNumOfHeadsOfHHandAdults365Days(BigInteger.valueOf(adultStayersHoh365Days !=null ? adultStayersHoh365Days.size() : 0));
			//TODO : Sandeep need to calculate this.
			// Number of parenting youth under age 25 with children
			String parent18To24YouthQuery = " select distinct(e.dedup_client_id) from %s.enrollment e, %s.enrollment e1,%s.project p where e.householdid = e1.householdid and  e.ageatentry >=18 and e.ageatentry <= 24 and e.relationshiptohoh='1'  and e1.relationshiptohoh='2' and e.projectid=p.id  %p ";
			int parent18To24Size= getSize(getClients(data, parent18To24YouthQuery, null, true));
		
			bean.setNumOfParentingYouthUnderAge25WithChildren(BigInteger.valueOf(parent18To24Size));
			bean.setNumOfYouthUnderAge25(BigInteger.valueOf(youthUnder25 !=null ? youthUnder25.size() : 0));
			bean.setTotNoOfAdultLeavers(BigInteger.valueOf(adultLeavers !=null ? adultLeavers.size() : 0));
			bean.setTotNoOfAdultStayers(BigInteger.valueOf(adultStayers !=null ? adultStayers.size() : 0));
			bean.setNoOfAdultHeadsOfHousehold(BigInteger.valueOf(adultHoh !=null ? adultHoh.size() : 0) );
			bean.setTotNoOfLeavers(BigInteger.valueOf(getSize(leavers)));
			
			bean.setTotNoOfStayers(BigInteger.valueOf(getSize(activeClients)));
			
			//bean.setTotNumOfPersonServed(BigInteger.valueOf(clients.size()));
			
			data.setTotNumOfPersonServed(bean.getTotNumOfPersonServed());  //Refers --> Total number of persons served 
			data.setNumOfAdults(bean.getNumOfAdults()); //Refers --> Number of adults (age 18 or over)
			data.setNumOfChildren(bean.getNumOfChildren()); //Refers --> Number of children (under age 18)
			data.setPersonsWithUnknownAge(ageUnknown); // Refers --> Number of persons with unknown age
			data.setTotNoOfAdultLeavers(bean.getTotNoOfAdultLeavers()); //Refers --> Number of adult leavers
			data.setNumOfAdultandHeadOfHHLeavers(bean.getNumOfAdultandHeadOfHHLeavers()); // Refers --> Number of adult and head of household leavers
			data.setTotNoOfAdultStayers(bean.getTotNoOfAdultStayers()); // Refers --> Number of adult stayers
			data.setNoOfChronicallyHomelessPersons(bean.getNoOfChronicallyHomelessPersons()); // Refers --> Number of chronically homeless persons
			data.setNumOfYouthUnderAge25(bean.getNumOfYouthUnderAge25()); // Refers --> Number of youth under age 25
			data.setNumOfParentingYouthUnderAge25WithChildren(bean.getNumOfParentingYouthUnderAge25WithChildren()); // Refers --> Number of parenting youth under age 25 with children
			data.setNoOfAdultHeadsOfHousehold(bean.getNoOfAdultHeadsOfHousehold()); //Refers --> Number of adult heads of household
			data.setNoOfChildHeadsOfHousehold(bean.getNoOfChildHeadsOfHousehold()); // Refers --> Number of child and unknown-age Heads of household
			data.setNumOfHeadsOfHHandAdults365Days(bean.getNumOfHeadsOfHHandAdults365Days()); // Refers --> Heads of households and adult stayers in the project 365 days or more
			
		}catch(Exception e) {
			logger.error("Error in Q05aBeanMaker:"+e);
		}
		}
        return Arrays.asList(bean);
    }
}
