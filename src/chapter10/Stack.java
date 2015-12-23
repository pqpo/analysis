package chapter10;

public class Stack<T>{

	private int size;
	private Object[] elementData;

	public Stack(){
		this(16);
	}

	public Stack(int initialCapacity){
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "+
					initialCapacity);
		this.elementData = new Object[initialCapacity];
	}

	public void push(T t){
		if(size==elementData.length-1){
			Object[] newData = new Object[(int) (elementData.length*1.5)];
			System.arraycopy(elementData, 0, newData, 0, elementData.length);
			elementData = newData;
		}
		size++;
		elementData[size] = t;
	}

	public T pop(){
		if(size==0){
			throw new RuntimeException("underflow");
		}
		@SuppressWarnings("unchecked")
		T ret = (T) elementData[size];
		elementData[size] = null;
		size--;
		return ret;
	}

	public boolean isEmpty(){
		return size==0;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<20;i++){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
