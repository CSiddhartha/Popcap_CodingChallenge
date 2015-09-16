package com.popcap.diceonyacht.Categories;

import com.popcap.diceonyacht.utils.Constants;
import com.popcap.diceonyacht.utils.Utilities;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class FullHouse implements Category {

    private int successScore = Constants.FULLHOUSE_SUCCESSSCORE;

    private int failedScore = Constants.FULLHOUSE_FAILSCORE;

    @Override
    public boolean isValid(int[] input) {
    	 if(input == null )
             return false;
    	 
        if(Utilities.getMaximumElement(input) == 3)
            return isFullHouse(input);
        return false;
    }

    private boolean isFullHouse(int[] input) {
        if(input[0] == input [2])
            return input[3] == input [4];
        else if (input[2] == input [4])
            return input[0] == input [1];
        else
            return false;
    }

    @Override
    public int getScore(int[] input) {
        if(isValid(input))
            return successScore;
        else
            return failedScore;
    }
}
