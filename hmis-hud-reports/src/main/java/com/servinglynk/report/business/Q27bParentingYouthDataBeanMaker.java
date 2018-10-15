package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27bParentingYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27bParentingYouthDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q27bParentingYouthDataBean> getQ27bParentingYouthList(ReportData data){
		
		Q27bParentingYouthDataBean q27bParentingYouthTable = new Q27bParentingYouthDataBean();
		try {
			if(data.isLiveMode()) {
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalPersons(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalHouseholds(BigInteger.valueOf(0));

				q27bParentingYouthTable.setQ27bParentYouth18To24TotalParentingYouth(data.getNumOfParentingYouthUnderAge25WithChildren());
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalPersons(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalHouseholds(BigInteger.valueOf(0));
			}
		}catch(Exception e) {
			logger.error("Error in Q26hBeanMaker:" + e);
		}
		
		return Arrays.asList(q27bParentingYouthTable);
		
	}

}
