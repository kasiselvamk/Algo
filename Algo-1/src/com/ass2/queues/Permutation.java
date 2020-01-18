package com.ass2.queues;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	   public static void main(String[] args) {

			int k = Integer.parseInt(args[0]);
			RandomizedQueue<String> rq = new RandomizedQueue<>();

			while (!StdIn.isEmpty()) {
				   rq.enqueue(StdIn.readString());
			}
			   //{"AA","BB","CC","DD","EE"}; 
		 //  if(k >fileData.length-1 ) throw new IllegalArgumentException();
		
		   for(int i=1;i<=k;i++) {
		   System.out.println(rq.dequeue());
	   }
 
  }
}
