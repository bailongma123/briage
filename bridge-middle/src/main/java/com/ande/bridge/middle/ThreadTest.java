package com.ande.bridge.middle;

import java.util.Scanner;

public class ThreadTest {  
   private static String[] str;  
    public static void main(String[] args){  
    	System.out.println(test(12.74));
}
public static double test(double n){
    int integer = (int)n;  //整数部分
    double decimal=n-integer;//小数部分
    if(decimal<0.3){
    	return integer-1+0.99;
    }else if(0.3<decimal&&decimal<0.5){
    	return integer+0.49;
    }else{
    	return integer+0.99;
    }
}  
}