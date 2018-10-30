package com.ll.algorithm.acm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ll.algorithm.util.CommonUtils;

public class 一维数组最大累加和 {

	public static void main(String[] args) {
		int[] in = CommonUtils.RandomS.getRandomIntArray(15, 10);
		// int [] in ={8, -2, 2, -1, 6, -3, 8, 0, 0, 2, -2, -4, -1, -6, -7};
		System.out.println(Arrays.toString(in));
//		List<Map<String, Object>> all = new ArrayList<>();
		Map<String, Object> result = getMax(in, 0, in.length - 1);
		System.out.println(result);
	}

	public static Map<String, Object> getMax(int[] in, int start, int last) {
		int max = 0;
		int sum = 0;
		int begin = start;
		int end = begin;
		boolean change = false;
		Map<String, Object> result = null;
		for (int i = start; i <= last; i++) {
			//过滤开始小于0的数
			if (sum == 0 && in[i] <= 0) {
				begin = start = i + 1;
				continue;
			}
			sum += in[i];
			if (sum <= 0) {
				//递归计算i+1至end的最大值，并将其与当前的最大值比较，取最大值
				Map<String, Object> tempMap = getMax(in, i + 1, in.length - 1);
				int tempMax = (Integer) tempMap.get("max");
				if (max < tempMax) {
					max = tempMax;
					change = true;
					result = tempMap;
				}
			}
			if (sum > max) {
				max = sum;
				end = i;
			}
		}
		if (max == 0) {
			begin = 0;
			end = 0;
		}
		if (!change) {
			result = CommonUtils.MapUtils.createMap("max", max, "begin", begin,
					"end", end);
		}
		return result;
	}

	public static Map<String, Object> getMax(int[] in, int start, int last,
			List<Map<String, Object>> allResult) {
		int max = 0;
		int sum = 0;
		int begin = start;
		int end = 0;
		boolean change = false;
		Map<String, Object> result = null;
		for (int i = start; i <= last; i++) {
			if (sum == 0 && in[i] <= 0) {
				begin = start = i + 1;
				continue;
			}
			sum += in[i];
			if (sum <= 0) {
				Map<String, Object> tempMap = getMax(in, i + 1, in.length - 1);
				int tempMax = (Integer) tempMap.get("max");
				if (max < tempMax) {
					allResult.clear();
					max = tempMax;
					change = true;
					result = tempMap;
				}else if(max == tempMax){
					allResult.add(tempMap);
					change = true;
				}
			}
			if (sum > max) {
				max = sum;
				end = i;
			}
		}
		if (max == 0) {
			begin = 0;
			end = 0;
		}
		if (!change) {
			result = CommonUtils.MapUtils.createMap("max", max, "begin", begin,
					"end", end);
		}
		return result;
	}
	
	/**
	 * 递归求解
	 * 
	 * 思想是：分成两部分递归，第一部分从begin到mid，第二部分从mid+1到end
	 * 当begin==end时，递归结束，执行getCrossMax进行合并
	 * 方法getCrossMax用于从mid向左向右累加计算最大值
	 * @param in
	 * @param start
	 * @param end
	 * @return
	 */
	public static Map<String,Object> recursiveOperator(int[] in, int start, int end){
		if(start==end){
			return CommonUtils.MapUtils.createMap("max",in[start],"begin",start,"end",start);
		}
		int mid = (start+end)/2;
		//从begin位置开始到mid位置递归求解
		Map<String,Object> leftResult =  recursiveOperator(in, start, mid);
		//从mid+1位置开始到end位置递归求解
		Map<String,Object> rightResult = recursiveOperator(in, mid+1, end);
		Map<String,Object> crossResult = getCrossMax(in,start,mid,end);
		int leftMax = (Integer) leftResult.get("max");
		int rightMax = (Integer)rightResult.get("max");
		int crossMax = (Integer)crossResult.get("max");
		if(leftMax>=rightMax&&leftMax>=crossMax){
			return leftResult;
		}else if(rightMax>=leftMax&&rightMax>=crossMax){
			return rightResult;
		}else{
			return crossResult;
		}
		
	}

	/**
	 * 当递归程序上升时调用此方法合并求解
	 * @param in
	 * @param start
	 * @param mid
	 * @param end
	 * @return
	 */
	private static Map<String, Object> getCrossMax(int[] in, int start, int mid, int end) {
		int leftMax = 0;
		int leftSum = 0;
		int leftIndex = mid;
		int rightMax = 0;
		int rightSum = 0;
		int rightIndex = mid+1;
		for(int i=mid;i>=start;i--){
			leftSum+=in[i];
			if(leftSum>leftMax){
				leftMax = leftSum;
				leftIndex = i;
			}
		}
		for(int i=mid+1;i<=end;i++){
			rightSum+=in[i];
			if(rightSum>rightMax){
				rightMax = rightSum;
				rightIndex=i;
			}
		}
		return CommonUtils.MapUtils.createMap("max",leftMax+rightMax,"begin",leftIndex,"end",rightIndex);
	}
}
