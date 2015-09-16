package com.popcap.diceonyacht.Categories;

import com.popcap.diceonyacht.utils.Constants;
import com.popcap.diceonyacht.utils.Utilities;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class FourOfAKind implements Category {

    private final int successScore = Constants.FOUROFAKIND_SUCCESSSCORE;

    private final int failedScore = Constants.FOUROFAKIND_FAILSCORE;

    @Override
    public boolean isValid(int[] input) {
    	 if(input == null )
             return false;
    	 
        return Utilities.getMaximumElement(input) == 4 ? true : false;
    }

    @Override
    public int getScore(int[] input) {
        if(isValid(input))
            return successScore;
        else
            return failedScore;
    }
}