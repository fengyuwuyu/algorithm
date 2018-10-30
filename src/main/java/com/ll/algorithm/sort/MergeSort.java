package com.ll.algorithm.sort;

/**
 * 归并排序
 * 
 * @author lilei
 * 
 */
public class MergeSort implements Sort<Integer> {

	public void sort(Integer[] arr) {
		this.sort(arr, 0, arr.length - 1);
	}

	/**
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
	public void sort(Integer[] arr, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			this.sort(arr, begin, mid);
			this.sort(arr, mid + 1, end);
			this.merge(arr, begin, mid, end);
		}
	}

	/**
	 * 常规合并算法，效率较低
	 * @param arr
	 * @param begin
	 * @param mid
	 * @param end
	 */
	private void merge(Integer[] arr, int begin, int mid, int end) {
		int len1 = mid - begin + 1;
		int len2 = end - mid;
		Integer[] arr1 = new Integer[len1];
		Integer[] arr2 = new Integer[len2];
		for (int i = 0; i < len1; i++) {
			arr1[i] = arr[begin + i];
		}
		for (int j = 0; j < len2; j++) {
			arr2[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0;
		while (i < len1 && j < len2) {
			if (arr1[i] < arr2[j]) {
				arr[begin++] = arr1[i++];
			} else {
				arr[begin++] = arr2[j++];
			}
		}
		if (i == len1) {
			while (j < len2) {
				arr[begin++] = arr2[j++];
			}
		} else {
			while (i < len1) {
				arr[begin++] = arr1[i++];
			}
		}
	}

	/**
	 * 算法导论原书程序，使用两个最大值作为哨兵，以防止每次判断是否遍历结束，效率最高
	 * @param arr
	 * @param begin
	 * @param mid
	 * @param end
	 */
	private void merge1(Integer[] arr, int begin, int mid, int end) {
		int len1 = mid - begin + 1;
		int len2 = end - mid;
		Integer[] arr1 = new Integer[len1+1];
		Integer[] arr2 = new Integer[len2+1];
		for (int i = 0; i < len1; i++) {
			arr1[i] = arr[begin + i];
		}
		for (int j = 0; j < len2; j++) {
			arr2[j] = arr[mid + 1 + j];
		}
		arr1[len1] = Integer.MAX_VALUE;
		arr2[len2] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = begin; k <= end; k++) {
			if(arr1[i]<=arr2[j]){
				arr[k] = arr1[i++];
			}else{
				arr[k] = arr2[j++];
			}
		}
	}
}
