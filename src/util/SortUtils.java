package util;

import java.text.NumberFormat;

import common.Sorter;

public class SortUtils {
	
	public static void sortTest(Sorter sortable,int len){
		sortTest(sortable,len,Integer.MAX_VALUE);
	}
	
	public static void sortTest(Sorter sortable,int len,boolean debug){
		sortTest(sortable,len,Integer.MAX_VALUE,debug);
	}
	
	public static void sortTest(Sorter sortable,int len,int max){
		sortTest(sortable,len,max,false);
	}
	
	public static void sortTest(Sorter sortable,int len,int max,boolean debug){
		int[] array = ArrayUtils.getRandomIntArray(len, max);
		if(debug){
			System.out.println("Before: "+ArrayUtils.join(array, ","));
		}
		long time = System.currentTimeMillis();
		int[] sorted = sortable.sort(array);
		if(debug){
			System.out.println("After: "+ArrayUtils.join(sorted, ","));
		}
		System.out.println("Array length: "+ NumberFormat.getInstance().format(len) +"  Time consuming:" + (System.currentTimeMillis()-time)/1000+"s");
	}
}
