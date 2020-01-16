package com.binarysearch;

import java.util.Arrays;

public class BinarySearch {

	static int []arr ;
	
	public static void main(String[] args) {
		arr = new int [20];
		for(int i=0;i<20;i++) {arr[i]=i;}
         System.out.println(Arrays.toString(arr));
         System.out.println(find(199));

	}
	
	public static int find (int val) { 
		    int low = 0;
	        int high = arr.length - 1;

	        while (low <= high) {
	            int mid = (low + high)/ 2;
 	            if (arr[mid] < val)
	                low = mid + 1;
	            else if (arr[mid] > val)
	                high = mid - 1;
	            else
	                return mid; // key found
	        }
	        return -(low + 1);  // key not found.
	}
}
