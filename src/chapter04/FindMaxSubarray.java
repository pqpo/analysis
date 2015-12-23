package chapter04;

import util.ArrayUtils;

/**
 * 寻找最大子数组和
 * @author pqpo
 *
 */
public class FindMaxSubarray {

	public static void main(String[] args) {
		int[] randomIntArray = ArrayUtils.getRandomIntArray(5);
		System.out.println(ArrayUtils.join(randomIntArray));
		System.out.println(FindMaxSubarray.findMaxSubarraySum(randomIntArray));
	}

	public static int findMaxSubarraySum(int[] src){
		if(src==null){
			throw new IllegalArgumentException("src must not be null");
		}
		if(src.length==0){
			return Integer.MIN_VALUE;
		}
		return findMaxSubarraySum(src,0,src.length-1);
	}

	private static int findMaxSubarraySum(int[] src,int start,int end){
		if(start==end){
			return src[start];
		}
		int mid = (start+end)/2;
		int maxL = findMaxSubarraySum(src,start,mid);
		int maxR = findMaxSubarraySum(src,mid+1,end);
		int maxCross = findMaxCrossSubarraySum(src,start,mid,end);
		if(maxL>=maxR&&maxL>=maxCross){
			return maxL;
		}else if(maxR>=maxL&&maxR>=maxCross){
			return maxR;
		}else{
			return maxCross;
		}
	}

	private static int findMaxCrossSubarraySum(int[] src, int start, int mid, int end) {
		int maxL = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=mid;i>=start;i--){
			sum += src[i];
			if(sum>maxL){
				maxL = sum;
			}
		}
		int maxR = Integer.MIN_VALUE;
		sum = 0;
		for(int i=mid+1;i<=end;i++){
			sum += src[i];
			if(sum>maxR){
				maxR = sum;
			}
		}
		return maxR+maxL;
	}
}
