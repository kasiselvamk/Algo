package com.quickfind;

import java.util.Arrays;

public class QuickFind {

	private int [] id;
	
	QuickFind (int N){
		id = new int[N];
		for (int i=0 ; i<N;i++) {
			id[i] = i;
		} 
		System.out.println("Initial:"+Arrays.toString(id));
	
	}
	
	public void union(int p,int q) {
		int posp = id[p];
		int posq = id[q];
		
		for(int i=0;i<id.length;i++) {//
			if(id[i]==posp) id[i] = posq;
		}
		System.out.println(p +":"+ q+" Union :"+Arrays.toString(id));
	}
	
	public boolean connected(int p,int q) {
		boolean res =  id[p] == id[q];
		System.out.println(p +":"+ q+" is connected :"+ res);
		return res;
	}
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(4,3);
	    qf.union(3,8);
		qf.union(6,5);
		qf.union(9,4);
		qf.union(2,1);
		qf.connected(8,9 );
		qf.connected(5,0); 
		qf.union(5,0);
		qf.union(7,2);
		qf.union(6,1);	  
}

}
