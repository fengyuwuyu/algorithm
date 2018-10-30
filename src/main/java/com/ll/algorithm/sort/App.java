package com.ll.algorithm.sort;

import java.util.Arrays;

import com.ll.algorithm.util.CommonUtils;

/**
 * 测试排序算法
 * @author lilei
 *
 */
public class App {

	public static void main(String[] args) {
		Sort<Integer> sort = new MergeSort();
		Integer[] arr = CommonUtils.RandomS.getIntegerArray(100000, 100000);
		System.out.println(Arrays.toString(arr));
		long begin = System.currentTimeMillis();
		sort.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(System.currentTimeMillis()-begin);
	}
}
