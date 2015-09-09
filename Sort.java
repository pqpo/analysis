import java.util.Random;

public class Sort {
	
	public static void main(String[] args) {
		
		int[] a = new int[10000000];
		Random r = new Random();
		for(int i=0;i<a.length;i++){
			a[i] = r.nextInt();
		}
		
		int[] clonea = a.clone();
		int[] cloneb = a.clone();
		int[] clonec = a.clone();
		int[] cloned = a.clone();
		int[] clonee = a.clone();
		System.out.println("-------------------------------------");
		
		long timeB = System.currentTimeMillis();
		Sort.bubbleSort(clonea);
		System.out.println("冒泡排序耗时："+(System.currentTimeMillis()-timeB)+" 毫秒");
		
		timeB = System.currentTimeMillis();
		Sort.insertionSort(cloneb);
		System.out.println("插入排序耗时："+(System.currentTimeMillis()-timeB)+" 毫秒");
		
		timeB = System.currentTimeMillis();
		Sort.shellSort(clonec);
		System.out.println("希尔排序耗时："+(System.currentTimeMillis()-timeB)+"毫秒");
		
		timeB = System.currentTimeMillis();
		mergeSort(cloned);
		System.out.println("并归排序耗时："+(System.currentTimeMillis()-timeB)+" 毫秒");
		
		timeB = System.currentTimeMillis();
		quickSort(clonee);
		System.out.println("快速排序耗时  ："+(System.currentTimeMillis()-timeB)+" 毫秒");

	}
	
	public static void bubbleSort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j]<a[j-1]){
					int tmp = a[j];
					a[j]=a[j-1];
					a[j-1] = tmp;
				}
			}
		}
	}

	public static void insertionSort(int[] a){
		int j;
		for(int i=1;i<a.length;i++){
			int tmp = a[i];
			for(j=i;j>0&&tmp<a[j-1];j--){
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
	}
	
	public static void shellSort(int[] a){
		for(int gap = a.length/2;gap>0;gap/=2){
			for(int i=gap;i<a.length;i++){
				int tmp = a[i];
				int j;
				for(j=i;j>=gap&&tmp<a[j-gap];j-=gap){
					a[j] = a[j-gap];
				}
				a[j] = tmp;
			}
		}
	}
	
	public static void mergeSort(int[] a){
		int[] tmpArray = new int[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
	}
	
	private static void mergeSort(int[] a,int[] tmpArray,int left,int right ){
		if(left<right){
			int center = (left+right)/2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center+1, right);
			merge(a,tmpArray,left,center+1,right);
		}
	}

	private static void merge
	(int[] a, int[] temp, int leftStart, int rightStart, int rightEnd) {
		
		int leftEnd = rightStart-1;
		int tempPos = leftStart;
		int num = rightEnd-leftStart+1;
		
		while(leftStart<=leftEnd&&rightStart<=rightEnd){
			if(a[leftStart]>=a[rightStart]){
				temp[tempPos++] = a[rightStart++];
			}else{
				temp[tempPos++] = a[leftStart++];
			}
		}
		
		while(leftStart<=leftEnd){
			temp[tempPos++] = a[leftStart++];
		}
		
		while(rightStart<=rightEnd){
			temp[tempPos++] = a[rightStart++];
		}
		
		for(int i=0;i<num;i++,rightEnd--){
			a[rightEnd] = temp[rightEnd];
		}
		
	}
	
	public static void quickSort(int[] a){
		qSort(a,0,a.length-1);
	}
	
	private static void qSort(int[]a,int l,int r){
		if(l>=r){
			return;
		}
		int m = l;
		for(int i=l+1;i<=r;i++){
			if(a[i]<a[l]){
				m++;
				int tmp = a[i];
				a[i] = a[m];
				a[m] = tmp;
			}
		}
		int tmp = a[l];
		a[l] = a[m];
		a[m] = tmp;
		qSort(a,l,m-1);
		qSort(a,m+1,r);
	}
}
