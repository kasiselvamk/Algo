package com.ass1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int [][] perco;
	private WeightedQuickUnionUF qu;
	private int OpenSites;

	// creates n-by-n grid, with all sites initially blocked
	public Percolation(int n) {
	   if(n<=0) throw new IllegalArgumentException();
	
		perco = new int[n][n];int k = 0,N=(n*n)-1;
		qu = new WeightedQuickUnionUF(n*n);
		
		//Creating links for all top and bottom nodes.
		while (k<n-1) {
			qu.union(k,++k);
			qu.union(N--,N);
		}     	
	}
	private int getCorrespondingId(int row, int col,int length) {
		return ((row-1)*perco.length)+(col-1);
	}
	// opens the site (row, col) if it is not open already
	public void open(int row, int col){
		
		if( row <=0 || row>perco.length ) {
			throw new IllegalArgumentException();
		}else if ( col <=0 || col>perco.length ) {
			throw new IllegalArgumentException();
		} 
		if(!isOpen(row,col)) {
			perco[row-1][col-1] = 1;
			OpenSites++;
			int curPos = getCorrespondingId(row,col,perco.length);int p;
			//checking is neighbors has open (1)
			//DOWN
			if(row+1-1 < perco.length && perco[row+1-1][col-1] == 1) {
				p = getCorrespondingId(row+1,col,perco.length);
				qu.union(p, curPos);
			}
			//TOP
			if(row-1-1 >=0 &&  perco[row-1-1][col-1] == 1) {
				p = getCorrespondingId(row-1,col,perco.length);
				qu.union(p, curPos);
			}
			//RIGHT
			if(col+1-1 < perco.length && perco[row-1][col+1-1] == 1) {
				p = getCorrespondingId(row,col+1,perco.length);
				qu.union(p, curPos);
			}
			//LEFT
			if(col-1-1 >=0 && perco[row-1][col-1-1] == 1) {
				p = getCorrespondingId(row,col-1,perco.length);
				qu.union(p, curPos);
			}
		}	
	}
	// is the site (row, col) open?
	public boolean isOpen(int row, int col){
		if( row <=0 || row>perco.length ) {
			throw new IllegalArgumentException();
		}else if ( col <=0 || col>perco.length ) {
			throw new IllegalArgumentException();
		}else {
			return perco[row-1][col-1] == 1;
		}
	
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col){
		
		if( row <=0 || row>perco.length ) {
			throw new IllegalArgumentException();
		}else if ( col <=0 || col>perco.length ) {
			throw new IllegalArgumentException();
		} 
		
		if (isOpen(row, col)) {
			int root =qu.find(getCorrespondingId(row,col,perco.length));
			return qu.find(0) == qu.find(root);

		}else {
			return false;
		}
	}

	// returns the number of open sites
	public int numberOfOpenSites(){
		return OpenSites;
	}

	// does the system percolate?
	public boolean percolates(){
		return qu.find(0) == qu.find(perco.length*perco.length -1);
	}

	// test client (optional)
	public static void main(String[] args){
		int n = 5;
		
 		Percolation p = new Percolation(n);
		 
        System.out.println( p.percolates());
         
        
 		
	}
}
