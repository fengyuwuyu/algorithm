package com.ll.algorithm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 公共类
 * 
 * @author lilei
 * 
 */
public class CommonUtils {
	/** 公用不可变Random实例 */
	public static final Random RANDOM = new Random();
	private static final Integer MAX = 100;
	private static Scanner scanner = new Scanner(System.in);
	
	public static Integer[] initIntegerArray(int n){
		Integer [] result = new Integer[n];
		for(int i=0;i<n;i++){
			result[i] = 0;
		}
		return result;
	}
	
	public static Integer[] convert(String[] arr){
		if(arr==null||arr.length==0){
			return new Integer[0];
		}
		Integer[] result = new Integer[arr.length];
		for (int i=0;i<arr.length;i++) {
			result[i] = Integer.valueOf(arr[i]);
		}
		return result;
	}
	
	public static Integer getSum(Integer [] arr){
		if(arr==null||arr.length==0){
			return 0;
		}
		Integer sum = 0;
		for (Integer i : arr) {
			sum+=i;
		}
		return sum;
	}
	
	public static class ScannerS {
		
		public static String readLine(String msg){
			msg = msg==null?"请输入。。。":msg;
			System.out.println(msg);
			return scanner.nextLine();
		}
	}

	public static class RandomS {
		/**
		 * 返回随机生成的Integer数组
		 * 
		 * @param len
		 * @param max
		 * @return
		 */
		public static Integer[] getIntegerArray(Integer len, Integer max) {
			if (len == null || len <= 0) {
				return null;
			}
			max = max == null ? MAX : max;
			Integer[] result = new Integer[len];
			for (int i = 0; i < len; i++) {
				result[i] = getRandomInteger(max);
			}
			return result;
		}

		/**
		 * 随机生成Integer并返回
		 * 
		 * @param max
		 * @return
		 */
		public static Integer getRandomInteger(int max) {
			return RANDOM.nextInt(max);
		}

		/**
		 * 返回随机数组
		 * 
		 * @param length
		 *            表示数组的长度
		 * @param max
		 *            表示数组中元素的最大值，
		 * @return
		 */
		public static int[] getRandomIntArray(Integer length, Integer max) {
			if (length <= 0) {
				throw new IllegalArgumentException(
						"argument length must greater than 0");
			}
			if (max == null) {
				max = 100;
			}
			int[] result = new int[length];
			for (int i = 0; i < length; i++) {
				result[i] = getSignedInt(max);
			}
			return result;
		}

		public static Integer[] getRandomIntegerArray(Integer length,
				Integer max) {
			if (length <= 0) {
				throw new IllegalArgumentException(
						"argument length must greater than 0");
			}
			if (max == null) {
				max = 100;
			}
			Integer[] result = new Integer[length];
			for (int i = 0; i < length; i++) {
				result[i] = getSignedInt(max);
			}
			return result;
		}

		/**
		 * 根据传入的max，随机返回无符号的int值
		 * 
		 * @param max
		 *            返回元素的最大值
		 * @return
		 */
		public static int getSignedInt(int max) {
			int result = RANDOM.nextInt(max);
			return getRandom() * result;
		}

		/**
		 * 随机返回正负1
		 * 
		 * @return
		 */
		public static int getRandom() {
			int result = RANDOM.nextInt(2);
			return result == 0 ? -1 : 1;
		}
	}

	public static class MapUtils {
		/**
		 * args的长度必须是偶数，args奇数位的类型必须是String类型
		 * 
		 * @param args
		 *            Object数组
		 * @return
		 */
		public static Map<String, Object> createMap(Object... args) {
			if (args.length % 2 != 0) {
				throw new IllegalArgumentException("传入的参数必须是偶数！");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < args.length; i += 2) {
				if (!(args[i] instanceof String)) {
					throw new IllegalArgumentException("参数的奇数对象类型必须是String！");
				}
				map.put((String) args[i], args[i + 1]);
			}
			return map;
		}

		/**
		 * args的长度必须是偶数
		 * 
		 * @param args
		 *            Object数组
		 * @return
		 */
		public static Map<Object, Object> createMap1(Object... args) {
			if (args.length % 2 != 0) {
				throw new IllegalArgumentException("传入的参数必须是偶数！");
			}
			Map<Object, Object> map = new HashMap<Object, Object>();
			for (int i = 0; i < args.length; i += 2) {
				map.put((String) args[i], args[i + 1]);
			}
			return map;
		}

		/**
		 * 创建一个请求成功的Map
		 * 
		 * @param message
		 * @return
		 */
		public static Map<String, Object> createSuccessMap(Object... args) {
			Map<String, Object> successMap = null;
			if (args != null) {
				successMap = createMap(args);
			} else {
				successMap = new HashMap<String, Object>();
			}
			successMap.put("success", true);
			return successMap;
		}

		/**
		 * 创建一个请求失败的Map
		 * 
		 * @param message
		 * @return
		 */
		public static Map<String, Object> createFailedMap(Object... args) {
			Map<String, Object> failedMap = null;
			if (args != null) {
				failedMap = createMap(args);
			} else {
				failedMap = new HashMap<String, Object>();
			}
			failedMap.put("success", false);
			return failedMap;
		}

		public static Map<String, Object> createEmptyDataListMap() {
			return createSuccessMap("rows", new ArrayList<Object>(), "total", 0);
		}
	}
}
