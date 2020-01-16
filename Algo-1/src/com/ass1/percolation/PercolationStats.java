package com.ass1.percolation;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private double outcomes[];
	private Double mean ; 
	private Double stdDev ;
	private final Double  COEFF_95 = 1.960;
	// perform independent trials on an n-by-n grid
	public PercolationStats(int n, int trials) {
		
		if(n<=0||trials<=0) throw new IllegalArgumentException();

		int k=0;
		outcomes = new double[trials];
		while (trials-- > 0) {
			Percolation per = new Percolation(n);
			for(int i=1;;i++) {
				if(!per.percolates()) {
					per.open(StdRandom.uniform(n)+1, StdRandom.uniform(n)+1);
				}else {
					outcomes[k++]= (double)per.numberOfOpenSites()/(n*n);
					break;
				}
			}
		}
	}
	// sample mean of percolation threshold
	public double mean(){
		  if(mean == null ) mean = StdStats.mean(outcomes);
		return mean;	
	}
	// sample standard deviation of percolation threshold
	public double stddev(){
		if(stdDev == null) stdDev =  StdStats.stddev(outcomes);
		return stdDev;
	}
	// low endpoint of 95% confidence interval
	public double confidenceLo(){
		return mean() - (COEFF_95 * ( stddev()/Math.sqrt(outcomes.length)) );
	}

	// high endpoint of 95% confidence interval
	public double confidenceHi(){
		return mean() + (COEFF_95 * ( stddev()/Math.sqrt(outcomes.length)) );	
	}
	// test client (see below)
	public static void main(String[] args){
		int n = StdIn.readInt();
		int trials=StdIn.readInt();
		PercolationStats ps = new PercolationStats(n,trials);
		StdOut.printf("mean                    =%s\n",ps.mean() );
		StdOut.printf("stddev                  =%s\n",ps.stddev() );
		StdOut.printf("95%% confidence interval =[%s , %s]\n",ps.confidenceLo(),ps.confidenceHi());
	}  
}
