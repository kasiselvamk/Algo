package com.ass2.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node  first;
	private Node  last;
	private int size;
	private class DequeIterator implements Iterator<Item>{
		private Node  first;
		private Node  last;
 
		private int size;

		public DequeIterator(Node first, Node last,int size) {
			 this.first = first ; this.last = last;this.size = size;
		}
		
		@Override
		public boolean hasNext() {
			return  !(size <= 0);
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = first.item;
			first = first.next; 
			size--;
            return item;
		} 
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	private class Node{
 		 Item item;
 		 Node next;
 		 Node prev;
  	}
    // construct an empty deque
    public Deque() {}

    // is the deque empty?
    public boolean isEmpty() {
     	return size == 0; 
    }

    // return the number of items on the deque
    public int size() {
    	return size;
     }

    // add the item to the front
    public void addFirst(Item item) {
    	if(item ==  null) throw new IllegalArgumentException();
		Node n =  new Node();n.item =item;
    	if(isEmpty()) {
    		n.prev = n.next = n;
    		first = last = n;
    	}else {
        	Node tmp = first;
        	first = n;
        	n.next=tmp;
        	tmp.prev = first;
    	}
    	size++;
}

    // add the item to the back
    public void addLast(Item item) {
    	if(item ==  null) throw new IllegalArgumentException();
		Node n =  new Node();n.item =item;
    	if(isEmpty()) {
    		n.prev = n.next = n;
    		first = last = n;
    	}
    	Node tmp = last;
    	n.prev = tmp;
    	last = n;
    	tmp.next = last;
    	size++;
}

    // remove and return the item from the front
    public Item removeFirst() {
    	if(isEmpty()) throw new NoSuchElementException();
    	Item i = first.item;
    	first = first.next;
    	size--;
    	return i;
}

    // remove and return the item from the back
    public Item removeLast() {
    	if(isEmpty()) throw new NoSuchElementException();
    	Item i = last.item;
    	last = last.prev; 
    	size--;
    	return i;  	
}

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
		return new DequeIterator(first,last,size);
    	
    }

    // unit testing (required)
    public static void main(String[] args) {}

}