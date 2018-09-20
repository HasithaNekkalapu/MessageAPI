package com.remesh.interview.util;

import com.remesh.interview.dto.QueryParam;

public class Utils {

	public static QueryParam formQueryParamObject(String incomeRange, String age, String sex, String livingEnvironment)
			throws Exception {
		
		QueryParam queryParam = new QueryParam();
		
		queryParam.setAge(age);
		queryParam.setIncome(incomeRange);
		queryParam.setLivingEnvironment(livingEnvironment);
		queryParam.setSex(sex);
		
		return queryParam;
	}
	
}
