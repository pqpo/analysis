package chapter10;

public class Queue<T> {

	private Object[] elementData;
	private int head;
	private int tail;
	
	public Queue(){
		elementData = new Object[16];
	}
	
	public void enQueue(T t){
		elementData[tail] = t;
		tail++;
		if(tail==elementData.length){
			tail = 0;
		}
	}
	
	public T deQueue(){
		@SuppressWarnings("unchecked")
		T ret = (T) elementData[head];
		head++;
		if(head==elementData.length){
			head = 0;
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();

		for(int i=0;i<15;i++){
			q.enQueue(i);
		}
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		for(int i=20;i<23;i++){
			q.enQueue(i);
		}
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		
	}
	
}
