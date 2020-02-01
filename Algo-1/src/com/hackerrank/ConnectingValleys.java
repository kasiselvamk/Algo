package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	Stack<Character> valleys = new Stack<>();
    	Boolean isdown = Boolean.FALSE;
    	int counter = 0;
    	for (Character ch : s.toCharArray()) {
    		if(valleys.isEmpty() && ch =='D') {isdown= Boolean.TRUE;}
    		if(valleys.isEmpty()) {
    			valleys.push(ch); 
    		}else {
    			if(valleys.peek() != ch) {
    				valleys.pop(); 
    				if(valleys.isEmpty() && isdown ) {counter++;isdown = Boolean.FALSE;}
    		}else {
    			valleys.push(ch);
    			}
    		}
		}
    	System.out.println(counter);
		return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/kasiselvamk/git/Algo-1/Algo-1/out.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
