package chapter06;

import common.Sorter;
import util.SortUtils;

/**
 * 堆排序
 * @author pqpo
 *
 */
public class HeapSort implements Sorter{

	public static void main(String[] args) {
		HeapSort sortable = new HeapSort();
		SortUtils.sortTest(sortable, 20000000);
	}
	
	@Override
	public int[] sort(int[] src) {
		int heapSize = src.length;
		buildMaxHeap(src, heapSize);
		for(int i=src.length-1;i>0;i--){
			exchange(src, 0, i);
			heapSize--;
			maxHeapify(src, 0, heapSize);
		}
		return src;
	}
	
	public int[] buildMaxHeap(int[] src,int heapSize){
		for(int i= (src.length>>1)-1;i>=0;i--){
			maxHeapify(src, i, heapSize);
		}
		return src;
	}
	
	public void maxHeapify(int[] src,int index,int heapSize){
		int indexL = (index<<1)+1;
		int indexR = indexL+1;
		int larger = index;
		if(indexL<heapSize&&src[indexL]>src[index]){
			larger = indexL;
		}
		if(indexR<heapSize&&src[indexR]>src[larger]){
			larger = indexR;
		}
		if(larger!=index){
			exchange(src, index, larger);
			maxHeapify(src,larger,heapSize);
		}
		
	}
	
	public void exchange(int[]src,int a,int b){
		int tmp = src[a];
		src[a] = src[b];
		src[b] = tmp;
	}
}
