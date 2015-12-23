package chapter02;

import common.Sorter;
import util.SortUtils;

/**
 * 归并排序
 * @author pqpo
 *
 */
public class MergeSort implements Sorter{

	public static void main(String[] args) {
		//O(nlgn)
		//Array length: 10,000,000  Time consuming:3s
		//Array length: 20,000,000  Time consuming:6s
		//Array length: 30,000,000  Time consuming:10s
		//Array length: 50,000,000  Time consuming:18s
		//Array length: 100,000,000  Time consuming:36s
		Sorter sortable = new MergeSort();
		SortUtils.sortTest(sortable, 20000000);
	}

	@Override
	public int[] sort(int[] src) {
		if(src==null){
			return null;
		}
		return sort(src,0,src.length-1);
	}
	
	public int[] sort(int[]src,int start,int end){
		if(end<=start){
			return src;
		}
		int mid = (start+end)/2;
		sort(src,start,mid);
		sort(src,mid+1,end);
		return merge(src,start,mid,end);
	}

	private int[] merge(int[] src, int start, int mid, int end) {
		int[] tmpL = new int[mid-start+1];
		int[] tmpR = new int[end-mid];
		for(int i=0;i<tmpL.length;i++){
			tmpL[i] = src[start+i];
		}
		for(int j=0;j<tmpR.length;j++){
			tmpR[j] = src[mid+j+1];
		}
		int indexL = 0;
		int indexR = 0;
		for(;start<=end;start++){
			if(indexL>=tmpL.length&&indexR<tmpR.length){
				System.arraycopy(tmpR, indexR, src, start, tmpR.length-indexR);
				break;
			}
			if(indexR>=tmpR.length&&indexL<tmpL.length){
				System.arraycopy(tmpL, indexL, src, start, tmpL.length-indexL);
				break;
			}
			if(tmpL[indexL]<tmpR[indexR]){
				src[start] = tmpL[indexL];
				indexL++;
			}else{
				src[start] = tmpR[indexR];
				indexR++;
			}
		}
		return src;
	}
}
