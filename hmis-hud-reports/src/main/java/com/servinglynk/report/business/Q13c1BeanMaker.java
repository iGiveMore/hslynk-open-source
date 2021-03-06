package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13c1BeanMaker extends BaseBeanMaker{
	
	public static List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> getQ13c1PhysicalAndMentalHealthConditionsForStayersList(ReportData data){
	
	Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean q13c1Bean= new Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean();
	if(data.isLiveMode()) {
	try{
	
	List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
	List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
	List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
	List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
	
	// mental health -- select enrollment_id from disabilities where datacollectionstage =1 and disabilitytype='9'
	// alcohol --select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='1'
	// drug -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='2'
	// alcohol and drug -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='3'
	// Chronic Health Condition -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='7'
	// HIV/AIDS -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='8'
	// Physical Disability -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='5'
	// Developmental Disability -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='6'
	String query = " select distinct(e.dedup_client_id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5') and information_date >=e.entrydate  and information_date >=:startDate and information_date <=:endDate " ;
	String mentalHealthQuery = " and disabilitytype='9' ";
	Set<String> mentalHealthList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(), data,query+mentalHealthQuery);
	List<EnrollmentModel> enrollments = data.getEnrollments();   
	List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
	List<EnrollmentModel> enrollmentsHHWithOneAdults = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() > 18 ).collect(Collectors.toList());
	List<EnrollmentModel> enrollmentsHHWithOneChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() < 18 ).collect(Collectors.toList());	

	List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

	if(CollectionUtils.isNotEmpty(mentalHealthList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1MentalIllnessTotal(BigInteger.valueOf(mentalHealthList.size()));
    	q13c1Bean.setQ13c1MentalIllnessWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1MentalIllnessWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
    	q13c1Bean.setQ13c1MentalIllnessWithAdults(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	q13c1Bean.setQ13c1MentalIllnessWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1MentalIllnessUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String alcoholQuery = " and disabilitytype='10' and disabilityresponse='1' ";
	Set<String> alcoholList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data,query+alcoholQuery);
	if(CollectionUtils.isNotEmpty(alcoholList)) {
		
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
		q13c1Bean.setQ13c1AlcoholAbuseTotal(BigInteger.valueOf(alcoholList.size()));
    	q13c1Bean.setQ13c1AlcoholAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1AlcoholAbuseWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1AlcoholAbuseWithChildren(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size():0));
    	q13c1Bean.setQ13c1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	String drugQuery = " and disabilitytype='10' and disabilityresponse='2' ";
 	Set<String> drugList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, query+drugQuery);
	if(CollectionUtils.isNotEmpty(drugList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
	
		q13c1Bean.setQ13c1DrugAbuseTotal(BigInteger.valueOf(drugList.size()));
    	q13c1Bean.setQ13c1DrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1DrugAbuseWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1DrugAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	
    	q13c1Bean.setQ13c1DrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1DrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	
	String alcoholAndDrugQuery = " and disabilitytype='10' and disabilityresponse='3' ";
	Set<String> alcoholAndDrugList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, query+alcoholAndDrugQuery);
	if(CollectionUtils.isNotEmpty(alcoholAndDrugList)) {
 		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
		q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(alcoholAndDrugList.size()));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
        
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	
	}
	String chronicHealthCondition = " and disabilitytype='7' ";
	Set<String> chronicHealthConditionList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, query+chronicHealthCondition);
	if(CollectionUtils.isNotEmpty(chronicHealthConditionList)) {	
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
		q13c1Bean.setQ13c1ChronicHealthConditionTotal(BigInteger.valueOf(chronicHealthConditionList.size()));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String hivaids = "  and disabilitytype='8' ";
	Set<String> hivaidsList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data,query+hivaids);
	if(CollectionUtils.isNotEmpty(hivaidsList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1HIVRelatedDiseasesTotal(BigInteger.valueOf(hivaidsList.size()));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	
    	q13c1Bean.setQ13c1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String developmentDisability =   " and disabilitytype='6' ";
	Set<String> developmentDisabilityList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, query+developmentDisability);
	if(CollectionUtils.isNotEmpty(developmentDisabilityList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1DevelopmentalDisabilityTotal(BigInteger.valueOf(developmentDisabilityList.size()));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}

	
	String physicalDisabilitiy = " and disabilitytype='5' ";
	Set<String> physicalDisabilitiyList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, query+physicalDisabilitiy);
	if(CollectionUtils.isNotEmpty(physicalDisabilitiyList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdult = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
	   	q13c1Bean.setQ13c1PhysicalDisabilityTotal(BigInteger.valueOf(physicalDisabilitiyList.size()));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithAdults(BigInteger.valueOf(withOneAdult != null ? withOneAdult.size() : 0));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	} catch (Exception e) {
		logger.error("Error in Q13c1BeanMaker:" + e);
	}
	}
	return Arrays.asList(q13c1Bean);
	
	}


}
