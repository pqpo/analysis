package chapter07;

import common.Sorter;
import util.SortUtils;

/**
 * 快速排序
 * @author pqpo
 *
 */
public class QuickSort implements Sorter{

	
	public static void main(String[] args) {
		//O(nlgn)
		//Array length: 10,000,000  Time consuming:1s
		//Array length: 20,000,000  Time consuming:4s
		//Array length: 30,000,000  Time consuming:6s
		//Array length: 50,000,000  Time consuming:10s
		//Array length: 100,000,000  Time consuming:21s
		Sorter sortable = new QuickSort();
		SortUtils.sortTest(sortable, 10000000);
	}
	
	@Override
	public int[] sort(int[] src) {
		return quickSort(src,0,src.length-1);
	}

	private int[] quickSort(int[]src,int start,int end){
		if(start<end){
			int q = partition(src,start,end);
			quickSort(src,start,q-1);
			quickSort(src,q+1,end);
		}
		return src;
	}

	private int partition(int[] src, int start, int end) {
		int i = start-1;
//		Random r = new Random();
//		int t = r.nextInt(end-start+1)+start;
//		exchange(src, t, end);
		int x = src[end];
		for(int j=start;j<end;j++){
			if(src[j]<x){
				i++;
				exchange(src, i, j);
			}
		}
		exchange(src, i+1, end);
		return i+1;
	}
	
	public void exchange(int[]src,int a,int b){
		int tmp = src[a];
		src[a] = src[b];
		src[b] = tmp;
	}
}
