package chapter02;

import common.Sorter;
import util.SortUtils;

public class InsertSort implements Sorter{

	public int[] sort(int[] src){
		if(src==null){
			return src;
		}
		for(int i=1;i<src.length;i++){
			int tmp = src[i];
			int j = i-1;
			for(;j>=0&&src[j]>tmp;j--){
				src[j+1] = src[j];
			}
			src[j+1] = tmp;
		}
		return src;
	}
	
	public static void main(String[] args) {
		//指数增加O(n^2)
		//Array length: 100,000  Time consuming:2s
		//Array length: 200,000  Time consuming:8s
		//Array length: 300,000  Time consuming:18s
		//Array length: 400,000  Time consuming:33s
		Sorter sortable = new InsertSort();
		SortUtils.sortTest(sortable, 400000);
	}
}
