package com.ll.algorithm.sort;

/**
 * 插入排序
 * @author lilei
 *
 */
public class InsertionSort implements Sort<Integer> {

	public void sort(Integer[] arr) {
		if(arr==null||arr.length==0){
			return ;
		}
		for(int i=1;i<arr.length;i++){
			int  j = i-1;
			Integer key = arr[i];
			while(j>=0&&key<arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

	public void sort1(Integer[] arr){
		if(arr==null||arr.length==0){
			return;
		}
		for(int i=1;i<arr.length;i++){
			
		}
	}
	
	private void insertRightPosition(){
		
	}
	
	private int getIndex(Integer[] arr, Integer begin, Integer end, Integer x ){
		if(begin<0||begin>end){
			return -1;
		}
		if(begin==end){
			return x==arr[begin]?begin:-1;
		}
		int mid = (end-begin)/2;
		if(x>arr[mid]){
			return this.getIndex(arr, mid+1, end, x);
		}else if(x<arr[mid]){
			return this.getIndex(arr, begin, mid-1, x);
		}
		return mid;
	}
}
