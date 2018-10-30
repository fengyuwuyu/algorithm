package com.ll.algorithm.hiho;

import java.util.HashMap;
import java.util.Map;

import com.ll.algorithm.AlgorithmI;
import com.ll.algorithm.util.CommonUtils;

/**
 * <ul>
 * <li>详情请参考Projection.jpg</li>
 * <li>来源：http://hihocoder.com/problemset/problem/1045</li>
 * <li></li>
 * <li>描述</li>
 * <li>给n, L, R, C 和 n个整数 a1, ..., an。
 * 求实数b1, ..., bn使得，L ≤ bi ≤ R，且最小。（此处不完整，请参照Projection.jpg）</li>
 * <li></li>
 * <li>输入</li>
 * <li>第一行，一个整数T，表示测试点个数。接下来有T个测试点。</li>
 * <li>每个测试点中，第一行包含四个整数 n, L, R, C。 第二行，n 个整数 a1, ..., an。</li>
 * <li>1 ≤ n ≤ 10^6</li>
 * <li>输入数据中所有n的和 ≤ 10^6。</li>
 * <li>0 ≤ L ≤ R ≤ 10^3.</li>
 * <li>nL ≤ C ≤ nR.</li>
 * <li>0 ≤ ai ≤ 10^3.</li>
 * <li></li>
 * <li>输出</li>
 * <li>T行，每一行是对应测试点的答案(最小的)。如果答案不是整数，以最简分式形式输出。详见样例。</li>
 * <li>样例输入</li>
 * <li>3</li>
 * <li>2 5 7 12</li>
 * <li>5 6</li>
 * <li>2 5 7 12</li>
 * <li>5 7</li>
 * <li>2 5 7 12</li>
 * <li>10 10</li>
 * <li></li>
 * <li>样例输出</li>
 * <li>1/2</li>
 * <li>0</li>
 * <li>32</li>
 * </ul>
 * 
 * @author ll
 * 
 */
public class Projection implements AlgorithmI {

	/**
	 * 
	 */
	public Map<String, Object> in() {
		try {
			String line = CommonUtils.ScannerS.readLine("请输入要测试的次数。。。");
			int times = Integer.valueOf(line);
			while (times <= 0) {
				line = CommonUtils.ScannerS.readLine("测试次数必须大于0");
				times = Integer.valueOf(line);
			}
			Map<String, Object> result = new HashMap<String, Object>();
			for (int i = 0; i < times; i++) {
				line = CommonUtils.ScannerS
						.readLine("请输入数组长度、最小值、最大值和子数组的和，中间以空格分隔。。。");
				String[] data = line.split(" ");
				Integer[] d = CommonUtils.convert(data);
				line = CommonUtils.ScannerS.readLine("请输入数组，中间以空格分隔。。。");
				String[] aArray = line.split(" ");
				Integer[] aArr = CommonUtils.convert(aArray);
				result.put("r" + i, CommonUtils.MapUtils.createMap("times",
						times, "data", d, "aArr", aArr));
			}
			result.put("times", times);
			return result;
		} catch (Exception e) {
			System.out.println("输入数据格式错误，请重新开始。。。");
			Map<String, Object> result = this.in();
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	public Object operate() {
		try {
			Map<String, Object> result = this.in();
			Integer times = (Integer) result.get("times");
			for (int i = 0; i < times; i++) {
				Map<String, Object> ri = (Map<String, Object>) result.get("r" + i);
				Integer[] data = (Integer[]) ri.get("data");
				Integer[] aArr = (Integer[]) ri.get("aArr");
				int n = data[0];
				int l = data[1];
				int r = data[2];
				int c = data[3];
				Integer bArr = new Integer(aArr.length);
				float mod = c / n;
//				float result = 
				if (mod >= l && mod <= r) {
					
				}
			}

		} catch (Exception e) {
			System.out.println("输入数据格式错误，请重新开始。。。");
			this.operate();
		}
		return null;
	}

	public void out(Object o) {
		System.out.println(o.toString());
	}

}
