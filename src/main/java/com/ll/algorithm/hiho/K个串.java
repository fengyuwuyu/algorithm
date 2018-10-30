package com.ll.algorithm.hiho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ll.algorithm.util.CommonUtils;
import com.ll.algorithm.util.CommonUtils.MapUtils;

/**
 * <ul>
 * <li>来源：http://hihocoder.com/problemset/problem/1046</li>
 * <li>描述
 * <ul>
 * <li>兔子们在玩k个串的游戏。首先，它们拿出了一个长度为n的数字序列，选出其中的一个连续子串，然后统计其子串中所有数字</li>
 * <li>之和（注意这里重复出现的数字只被统计一次）。兔子们想知道，在这个数字序列所有连续的子串中，按照以上方式统计其所有数字之和，</li>
 * <li>第k大的和是多少。</li>
 * </ul>
 * </li>
 * 
 * <li>输入
 * <ul>
 * <li>第一行，两个整数n和k，分别表示长度为n的数字序列和想要统计的第k大的和</li>
 * <li>接下里一行n个数a_i，表示这个数字序列</li>
 * </ul>
 * </li>
 * <li>输出
 * <ul>
 * <li>一行一个整数，表示第k大的和</li>
 * </ul>
 * </li>
 * <li>数据范围
 * <ul>
 * <li>对于20%的数据，1 <= n <= 2000</li>
 * <li>对于另外20%的数据，0 <= a_i <= 10^9</li>
 * <li>对于100%的数据，1 <= n <= 100000, 1 <= k <= 200000, 0 <= |a_i| <= 10^9</li>
 * <li>数据保证存在第k大的和</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author ll
 * 
 */
public class K个串 {
	
	public Map<String,Object> in(){
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String [] a1 = line.split(" ");
		line = scanner.nextLine();
		String[] a2 = line.split(" ");
		Integer[] arr = CommonUtils.convert(a2);
		scanner.close();
		return MapUtils.createMap("k",a1[1],"arr",arr);
	}

	/**
	 * 将当前统计的子串和存放在一个长度为k的已排序数组中，每统计算出一个子串和就和该数组最小的比较， 若比最小的大，则踢掉最小的，将其插入到合适的位置
	 */
	public void oprator1(Map<String, Object> map) {
		int k = (Integer) map.get("k");
		Integer[] arr = (Integer[]) map.get("arr");
		int n = arr.length;
		if (k <= 0 || arr == null || n == 0) {
			System.out.println(0);
		}
		Integer[] res = CommonUtils.initIntegerArray(k);
		List<Integer> list = new ArrayList<Integer>();
		for (int m = 1; m <= n; m++) {
			for (int i = 0; i <= n-m; i++) {
				int temp = 0;
				list.clear();
				for (int j = i; j < m+i; j++) {
					if(!list.contains(arr[j])){
						temp += arr[j];
					}
					list.add(arr[j]);
				}
				this.compareAndSort(res, temp);
			}
		}
		System.out.println(res[0]);
	}

	/**
	 * @param arr
	 *            长度为k的已排序数组
	 * @param val
	 *            插入的子串和
	 */
	private void compareAndSort(Integer[] arr, Integer val) {
		if (val > arr[0]) {
			for (int i = 1; i < arr.length; i++) {
				if (val > arr[i]) {
					arr[i - 1] = arr[i];
					if(i==arr.length-1){
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
		K个串 app = new K个串();
		Map<String,Object> map = app.in();
		app.oprator1(map);
	}
}
