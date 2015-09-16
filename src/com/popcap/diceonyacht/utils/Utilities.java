package com.popcap.diceonyacht.utils;


/**
 * Created by Siddhartha on 9/16/2015.
 */
public class Utilities {

    public static int getSum(int[] input, int value) {
        int sum = 0;
        if(input != null){
	        for(int i : input) {
	            if(i == value)
	                sum = sum  + value;
	        }
	        return sum;
        }
        return -1;
    }

    public static int getMaximumElement(int[] input) {
        int counter = 0;
        int midValue = input[input.length/2];
        int c1 = input.length/2;
        int c2 = c1 + 1;
        while(c1 >= 0) {
            if(input[c1] == midValue)
                counter++;
            else
                break;
            c1--;
        }

        while(c2 <= input.length-1) {
            if(input[c2] == midValue)
                counter++;
            else
                break;
            c2++;
        }
        return counter;
    }
}
