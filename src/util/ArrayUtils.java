package util;

import java.util.Random;

public class ArrayUtils {

	public static String join(int[] array,String sp){
		if(array==null){
			return "";
		}
		if(sp==null){
			sp = ",";
		}
		StringBuilder sb = new StringBuilder();
		int len = array.length;
		for(int i=0;i<len;i++){
			sb.append(array[i]);
			if(i!=len-1){
				sb.append(sp);
			}
		}
		return sb.toString();
	}

	public static String join(int[] array) {
		return join(array,",");
	}
	
	public static int[] getRandomIntArray(int len,int max){
		int[] src = new int[len];
		Random random = new Random();
		for(int i=0;i<src.length;i++){
			src[i] = random.nextInt(max);
		}
		return src;
	}
	
	public static int[] getRandomIntArray(int len){
		int[] src = new int[len];
		Random random = new Random();
		for(int i=0;i<src.length;i++){
			src[i] = random.nextInt();
		}
		return src;
	}
	
}
