package com.popcap.diceonyacht.Categories;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public interface Category {

    boolean isValid(int[] input);

    int getScore(int[] input);
}
