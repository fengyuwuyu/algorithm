package com.ll.algorithm.acm;

/**
 * 问题描述：
 * 		每天从若干求职者中选出一人与当前已经雇佣的员工进行比较，若比当前的员工强，则开出当前员工，雇佣新人，求当为n时，雇佣的总开销
 * 输入：
 * 		大小为n的列表
 * 输出：
 * 		雇佣到最佳员工的开销
 * @author ll
 *
 */
public class 最大雇佣费用问题 {
	
	public Integer getMaxCost(Integer[] employees,int cost,int proxyCost){
		if(employees==null||employees.length==0)
			return null;
		int better = 0;
		int totalCost = 0;
		for(Integer employee : employees){
			totalCost += proxyCost;
			if(employee>better){
				totalCost+=cost;
				better = employee;
			}
		}
		return totalCost;
	}
	
}
