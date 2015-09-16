package com.popcap.diceonyacht.Categories;

import com.popcap.diceonyacht.utils.Constants;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class LargeStraight extends AllDifferent {

    private final int successScore = Constants.LARGESTRAIGHT_SUCCESSSCORE;

    private final int failedScore = Constants.LARGESTRAIGHT_FAILSCORE;

    public boolean isValid(int[] input) {
    	 if(input == null )
             return false;
    	 
        if(super.isValid(input))
            return isConsecutive(input);
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

    private boolean isConsecutive(int[] input) {
        if(input == null)
            return false;

        if(input.length == 1)
            return true;

        int prev = input[0];
        for(int i=1; i<input.length; i++) {
            if(input[i]-prev != 1) {
                return false;
            }
            prev = input[i];
        }
        return true;
    }


}
