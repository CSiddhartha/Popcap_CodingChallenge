package com.popcap.diceonyacht.Categories;
import com.popcap.diceonyacht.utils.Constants;
import com.popcap.diceonyacht.utils.Utilities;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class AllSame implements Category {

    private final int successScore = Constants.ALLSAME_SUCCESSSCORE;

    private final int failedScore = Constants.ALLSAME_FAILSCORE;

    @Override
    public boolean isValid(int[] input) {
    	 if(input == null )
             return false;
    	 
        return Utilities.getMaximumElement(input) == input.length ? true : false;
    }

    @Override
    public int getScore(int[] input) {
        if(isValid(input))
            return successScore;
        else
            return failedScore;
    }
}