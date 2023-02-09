package com.co.practice;

import java.io.*;
import java.util.*;


/**
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem?isFullScreen=true
 */
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here
    public PerformOperation isOdd(){
        return n -> n % 2 != 0;
    }
    public PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public PerformOperation isPalindrome() {
        return n -> {
            String s = String.valueOf(n);
            String n2 = "";
            for (int i = s.length()-1; i >= 0; i--){
                n2 = n2+s.charAt(i);
            }
            if (n2.equals(s)) {
                return true;
            }
            return false;
        };
    }
}
public class Lamdas {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
