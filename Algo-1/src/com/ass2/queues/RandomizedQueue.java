package com.ass2.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Node  first;
	private Node  last;
	private int size;
	private class RandomizedQueueIterator implements Iterator<Item>{
		private Node  first;
		private Node  last;
 
		private int size;

		public RandomizedQueueIterator(Node first, Node last,int size) {
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
    public RandomizedQueue() { }

    // is the deque empty?
    public boolean isEmpty() {
     	return size == 0; 
    }

    // return the number of items on the deque
    public int size() {
    	return size;
     }
    
    private int getRandom() {
    	int rand =StdRandom.uniform(size);
    	return rand;
    }

    private Node findNode(int index) {
    	Node node = first;
    	for (int i=0;i<index;i++) {
    		node = node.next;
    	}
    	return node;
    }
    

    // add the item to the front
    private void addFirst(Item item) {
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
  
    

    // add the item
    public void enqueue(Item item) {
    	if(item == null) throw new IllegalArgumentException();
    	addFirst(item);
    	
    }

    // remove and return a random item
    public Item dequeue() {
    	if(size ==0 ) throw new NoSuchElementException();

    	Node toremove = findNode(getRandom());
    	
    	Node prev = toremove.prev;
    	Node next = toremove.next;
    	
    	if(prev!=null && toremove!=null ) prev.next = toremove.next;
    	if(next!=null && toremove!=null ) next.prev = toremove.prev;
    	size--;
    	Item item = toremove.item;toremove = null;
    	return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if(size ==0 ) throw new NoSuchElementException();
    	return findNode(getRandom()).item;
    	
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
		return new RandomizedQueueIterator(first,last,size);
    	
    }

    // unit testing (required)
    public static void main(String[] args) {}

}