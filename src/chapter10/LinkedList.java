package chapter10;

import java.util.NoSuchElementException;

public class LinkedList<T> {

	private Node<T> header = null;
	private int size;
	
	public LinkedList(){
		header = new Node<T>(null, null, null);
		header.prev = header.next = header;
	}
	
	public T getFirst(){
		if (size==0)
		    throw new NoSuchElementException();

		return header.next.element;
	}
	
	public T getLast(){
		if (size==0)
		    throw new NoSuchElementException();

		return header.prev.element;
	}
	
	public T removeFirst(){
		return remove(header.next);
	}
	
	public T removeLast(){
		return remove(header.prev);
	}
	
	public void addFirst(T t){
		addBefore(t, header.next);
	}
	
	public void addLast(T t){
		addBefore(t, header);
	}
	
	public boolean add(T t) {
		addBefore(t, header);
	    return true;
	}
	
	private Node<T> addBefore(T e, Node<T> node) {
		Node<T> n = new Node<T>(node.prev, node, e);
		node.prev.next = n;
		node.prev = n;
		size++;
		return n;
	}
	
	private T remove(Node<T> e) {
		if (e == header)
		    throw new NoSuchElementException();
		T ret = e.element;
		e.prev.next = e.next;
		e.next.prev = e.prev;
		e.next = e.prev = null;
        e.element = null;
        size--;
		return ret;
	}

	private static class Node<T>{
		Node(Node<T> prev,Node<T> next,T element){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
		Node<T> prev;
		Node<T> next;
		T element;
	}
}
