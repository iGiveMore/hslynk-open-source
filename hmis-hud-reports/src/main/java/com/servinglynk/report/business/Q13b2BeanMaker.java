package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13b2NumberOfConditionsAtExitDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13b2BeanMaker extends BaseBeanMaker{
	
	public static List<Q13b2NumberOfConditionsAtExitDataBean> getQ13b2NumberOfConditionsAtExitList(ReportData data){
		
		Q13b2NumberOfConditionsAtExitDataBean q13b2Bean = new Q13b2NumberOfConditionsAtExitDataBean();
		if(data.isLiveMode()) {
		try{
		String query ="select dedup_client_id,count(dedup_client_id) as cnt from  %s.disabilities d, %s.enrollment e,%s.exit ext where e.id=d.enrollmentid and ext.enrollmentid=e.id and datacollectionstage='3' and TO_DATE(information_date) = TO_DATE(ext.exitdate)  and information_date <= :endDate ";
		
		String additionalQuery =" and ( disabilityresponse='1'  and ( disabilitytype='9' or disabilitytype='10' or  disabilitytype='7' or disabilitytype='8' or  disabilitytype='6')  or  (disabilitytype='10' and disabilityresponse='3') ) " ;
		
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		List<EnrollmentModel> enrollments = data.getLeavers();   
		List<EnrollmentModel>  ewithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel>  ewithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneAdults = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() > 18 ).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() < 18 ).collect(Collectors.toList());
	
		
		List<EnrollmentModel>  eunknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		Set<String> enrollmentsHHWithChildren = new HashSet<>();
		ewithChildren.forEach(enrollment-> enrollmentsHHWithChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOutChildren = new HashSet<>();
		ewithOutChildren.forEach(enrollment-> enrollmentsHHWithOutChildren.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsUnknownHouseHold = new HashSet<>();
		eunknownHouseHold.forEach(enrollment-> enrollmentsUnknownHouseHold.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOneAdultsSet = new HashSet<>();
		enrollmentsHHWithOneAdults.forEach(enrollment-> enrollmentsHHWithOneAdultsSet.add(enrollment.getDedupClientId()));
		
		Set<String> enrollmentsHHWithOneChildrenSet = new HashSet<>();
		enrollmentsHHWithOneChildren.forEach(enrollment-> enrollmentsHHWithOneChildrenSet.add(enrollment.getDedupClientId()));
		
		
    	BigInteger  totalUHHT = BigInteger.ZERO;
		BigInteger	totalWA = BigInteger.ZERO;
		BigInteger	totalWC = BigInteger.ZERO;
		BigInteger	totalWithOnlyChild = BigInteger.ZERO;
		BigInteger	totalWOC = BigInteger.ZERO;
		BigInteger  overallTotal = BigInteger.ZERO;
		Set<String> clients = new HashSet<>();
		List<DisabilitiesModel> disabilities = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, query +  additionalQuery);
		List<DisabilitiesModel> just1 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==1).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just1)) {
			List<DisabilitiesModel> withChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just1.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = just1.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			just1.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just1.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition1Total(BigInteger.valueOf(just1.size()));
	    	q13b2Bean.setQ13b2Condition1WithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition1WithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13b2Bean.setQ13b2Condition1WithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition1WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition1UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}


		List<DisabilitiesModel> just2 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() ==2).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(just2)) {
			List<DisabilitiesModel> withChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = just2.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = just2.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			just2.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(just2.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition2Total(BigInteger.valueOf(just2.size()));
	    	q13b2Bean.setQ13b2Condition2WithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition2WithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13b2Bean.setQ13b2Condition2WithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition2WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition2UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	
    	
		List<DisabilitiesModel> plus3 = disabilities.parallelStream().filter(disability -> disability.getDisabilityCount() >= 3).collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(plus3)) {
			List<DisabilitiesModel> withChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = plus3.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = plus3.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			plus3.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(plus3.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2Condition3PlusTotal(BigInteger.valueOf(plus3.size()));
	    	q13b2Bean.setQ13b2Condition3PlusWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2Condition3PlusUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		List<DisabilitiesModel> disabilitiesNone = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),  data,query+ "  and disabilityresponse='0'  ");
		if(CollectionUtils.isNotEmpty(disabilitiesNone)) {
			List<DisabilitiesModel> disabNone = disabilitiesNone.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(disabNone)) {
				List<DisabilitiesModel> withChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOutChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> unknownHouseHold = disabNone.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOneAdults = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				List<DisabilitiesModel> withOneChildren = disabNone.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
				
				disabNone.forEach(disability-> clients.add(disability.getDedupClientId()));
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
				int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				overallTotal=overallTotal.add(BigInteger.valueOf(disabNone.size()));
				totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
				totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
				totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				q13b2Bean.setQ13b2NoneTotal(BigInteger.valueOf(disabNone.size()));
				
		    	q13b2Bean.setQ13b2NoneWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
		    	q13b2Bean.setQ13b2NoneWithAdults(BigInteger.valueOf(withOneAdultIntSize));
		    	q13b2Bean.setQ13b2NoneWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
		    	q13b2Bean.setQ13b2NoneWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
		    	q13b2Bean.setQ13b2NoneUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
		}
		
		
		List<DisabilitiesModel> disabilitiesUnknown = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, query + "  and ( disabilityresponse='8' or disabilityresponse='9')  ");
		List<DisabilitiesModel> disabUnknown = disabilitiesUnknown.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())   ).collect(Collectors.toList());
		
		if(CollectionUtils.isNotEmpty(disabUnknown)) {
			List<DisabilitiesModel> withChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabUnknown.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = disabUnknown.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			
			disabUnknown.forEach(disability-> clients.add(disability.getDedupClientId()));
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabUnknown.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q13b2Bean.setQ13b2DontKnowRefusedTotal(BigInteger.valueOf(disabilitiesUnknown.size()));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		List<DisabilitiesModel> disabilitiesMissing = getEnrollmentFromDisabilitiesCountForLeavers(data.getSchema(),data, query + "  and disabilityresponse='99' ");		
		if(CollectionUtils.isNotEmpty(disabilitiesMissing)) {
			List<DisabilitiesModel> disabilitiesMiss = disabilitiesMissing.parallelStream().filter(enrollment -> !clients.contains(enrollment.getDedupClientId())   ).collect(Collectors.toList());
			List<DisabilitiesModel> withChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOutChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> unknownHouseHold = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneAdults = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOneAdultsSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
			List<DisabilitiesModel> withOneChildren = disabilitiesMissing.parallelStream().filter(enrollment -> enrollmentsHHWithOneChildrenSet.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		
			
			int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
			int withOneAdultIntSize = withOneAdults != null ? withOneAdults.size() :0;
			int withOneChildrenIntSize = withOneChildren != null ? withOneChildren.size() :0;
			int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
			int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
			
			overallTotal=overallTotal.add(BigInteger.valueOf(disabilitiesMiss.size()));
			totalWithOnlyChild=totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			totalWOC=totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			totalWA=totalWA.add(BigInteger.valueOf(withOneAdultIntSize));
			totalWC=totalWC.add(BigInteger.valueOf(withOneChildrenIntSize));
			totalUHHT=totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			
			q13b2Bean.setQ13b2InformationmissingTotal(BigInteger.valueOf(disabilitiesMissing.size()));
	    	q13b2Bean.setQ13b2InformationmissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
	    	q13b2Bean.setQ13b2InformationmissingWithAdults(BigInteger.valueOf(withOneAdultIntSize));
	    	q13b2Bean.setQ13b2InformationmissingWithChildren(BigInteger.valueOf(withOneChildrenIntSize));
	    	q13b2Bean.setQ13b2InformationmissingWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
	    	q13b2Bean.setQ13b2InformationmissingUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
    	q13b2Bean.setQ13b2TotalSummed(BigInteger.valueOf(getSize(enrollments)));
    	q13b2Bean.setQ13b2TotalWithoutChildren(totalWOC);
    	q13b2Bean.setQ13b2TotalWithAdults(totalWA);
    	q13b2Bean.setQ13b2TotalWithChildren(totalWC);
    	q13b2Bean.setQ13b2TotalWithOnlychildren(totalWithOnlyChild);
    	q13b2Bean.setQ13b2TotalUnknowHousehold(totalUHHT);
	} catch (Exception e) {
		logger.error("Error in q13b2BeanMaker:" + e);
	}
		}
    	return Arrays.asList(q13b2Bean);
    
		
	}

}
