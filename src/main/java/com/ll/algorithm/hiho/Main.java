package com.ll.algorithm.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public Map<String, Object> in() {
		Scanner scanner = new Scanner(System.in);
		String[] a1 = null;
		Integer[] arr = null;
		String line = scanner.nextLine();
		a1 = line.split(" ");
		line = scanner.nextLine();
		String[] a2 = line.split(" ");
		arr = convert(a2);
		scanner.close();
		return createMap("k", a1[1], "arr", arr);
	}

	public void oprator1(Map<String, Object> map) {
		int k = Integer.parseInt((String) map.get("k"));
		Integer[] arr = (Integer[]) map.get("arr");
		int n = arr.length;
		if (k <= 0 || arr == null || n == 0) {
			System.out.println(0);
		}
		Integer[] res = initIntegerArray(k);
		List<Integer> list = new ArrayList<Integer>();
		for (int m = 1; m <= n; m++) {
			for (int i = 0; i <= n - m; i++) {
				int temp = 0;
				list.clear();
				for (int j = i; j < m + i; j++) {
					if (!list.contains(arr[j])) {
						temp += arr[j];
					}
					list.add(arr[j]);
				}
				this.compareAndSort(res, temp);
			}
		}
		System.out.println(res[0]);
		System.out.println(Arrays.toString(res));
	}

	private void compareAndSort(Integer[] arr, Integer val) {
		if (val > arr[0]) {
			for (int i = 1; i < arr.length; i++) {
				if (val > arr[i]) {
					arr[i - 1] = arr[i];
					if (i == arr.length - 1) {
						arr[i] = val;
					}
				} else {
					arr[i - 1] = val;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Main app = new Main();
		Map<String, Object> map = app.in();
		app.oprator1(map);
	}

	private Integer[] convert(String[] arr) {
		if (arr == null || arr.length == 0) {
			return new Integer[0];
		}
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = Integer.valueOf(arr[i]);
		}
		return result;
	}

	private Map<String, Object> createMap(Object... args) {
		if (args.length % 2 != 0) {
			throw new IllegalArgumentException("aa");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < args.length; i += 2) {
			if (!(args[i] instanceof String)) {
				throw new IllegalArgumentException("aa");
			}
			map.put((String) args[i], args[i + 1]);
		}
		return map;
	}

	private Integer[] initIntegerArray(int n) {
		Integer[] result = new Integer[n];
		for (int i = 0; i < n; i++) {
			result[i] = 0;
		}
		return result;
	}
}
