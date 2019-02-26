package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean;

public class Q29bPerformanceMeasuresTransitionalHousingProgramsDataBeanMaker {
	
	public static List<Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean> getQ29bPerformanceMeasuresTransitionalHousingProgramsList(){
		
		Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean q29bPerformanceMeasuresTransitionalHousingProgramsTable = new Q29bPerformanceMeasuresTransitionalHousingProgramsDataBean();
		
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bHousingStabilityMeasureApplicableMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bHousingStabilityMeasureAccomplishedMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bHousingStabilityMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bTotalIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bTotalIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bTotalIncome(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bEarnedIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bEarnedIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29bPerformanceMeasuresTransitionalHousingProgramsTable.setQ29bEarnedIncome(BigInteger.valueOf(0));
		
		return Arrays.asList(q29bPerformanceMeasuresTransitionalHousingProgramsTable);
		
	}

}
