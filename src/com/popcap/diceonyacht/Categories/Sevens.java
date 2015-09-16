package com.popcap.diceonyacht.Categories;

import com.popcap.diceonyacht.utils.Utilities;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class Sevens implements Category {

    private int score = 0;

    @Override
    public boolean isValid(int[] input) {
        if(input == null)
            return false;

        if(input.length != 5)
            return false;

        return true;
    }

    @Override
    public int getScore(int[] input) {
        if(isValid(input))
            score = Utilities.getSum(input, 7);
        return score;
    }
}