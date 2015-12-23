package chapter06;

public class PriorityQueueImpl implements PriorityQueue{

	private HeapSort heap = new HeapSort();
	private int[] src;
	private int heapSize;
	
	public PriorityQueueImpl(int[] src) {
		this.src = heap.buildMaxHeap(src, src.length);
		heapSize = src.length;
	}
	
	@Override
	public void insert(int x) {
		//TODO
	}

	@Override
	public int maximum() {
		return src[0];
	}

	@Override
	public int extractMax() {
		if(heapSize<1){
			throw new RuntimeException("heap underflow");
		}
		int max = src[0];
		src[0] = src[heapSize-1];
		heapSize--;
		heap.maxHeapify(src, 0, heapSize);
		return max;
	}

	@Override
	public void increaseKey(int x, int k) {
		if(k<src[x]){
			throw new RuntimeException("new key is smaller than current key");
		}
		src[x] = k;
		while(x>=0&&src[x/2]<src[x]){
			heap.exchange(src, x, x/2);
			x = x/2;
		}
	}

}
