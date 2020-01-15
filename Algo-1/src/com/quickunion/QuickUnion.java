package com.quickunion;

import java.util.Arrays;

public class QuickUnion {
	
	private int [] id;
	
	QuickUnion(int N) {
		id = new int[N];
		for (int i=0 ; i<N;i++) {
			id[i] = i;
		} 
		System.out.println("Initial:"+Arrays.toString(id));
	}
	
	public void union (int p,int q) {
      int  rootp = root(p);
      int  rootq = root(q);
      id[p] = rootq;//
	  System.out.println(p +":"+ q+" Union :"+Arrays.toString(id));
	}
	
	private int root(int p) {
		while (p!=id[p]) {
			 p= id[p];
		}
		return p;
	}

	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		qu.union(4,3);
		qu.union(3,8);
		qu.union(6,5);
		qu.union(9,4);
		qu.union(2,1);
		qu.connected(8,9 );
		qu.connected(5,0); 
		qu.union(5,0);
		qu.union(7,2);
		qu.union(6,1);	
	}

	private boolean connected(int p, int q) {
		  int  rootp = root(p);
	      int  rootq = root(q);
	  boolean res = rootp == rootq;
		System.out.println(p +":"+ q+" is connected :"+ res);

	return res;
	}

}
