package com.hackerrank;
 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	int s_len = s.length();
    	long noOfAs = 0;
    	long count = 0;
    	char[] ch  = s.toCharArray();
         for(int i=0;i<ch.length;i++) {
			  if ( ch[i] == 'a' ) noOfAs ++;
		}
    	long occ = n/s_len;
    	long occPer = n%s_len;
    	count = occ*noOfAs;
    	System.out.println(occPer);
    	 for(int i=0;i<occPer;i++) {
			  if ( ch[i] == 'a' ) count ++;
		}
    	 System.out.println(count);
		return n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/kasiselvamk/git/Algo-1/Algo-1/out.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
