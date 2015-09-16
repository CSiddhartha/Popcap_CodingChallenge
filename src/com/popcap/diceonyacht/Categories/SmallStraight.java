package com.popcap.diceonyacht.Categories;

import com.popcap.diceonyacht.utils.Constants;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class SmallStraight implements Category {

    public int successScore = Constants.SMALLSTRAIGHT_SUCCESSSCORE;

    public int failedScore = Constants.SMALLSTRAIGHT_FAILSCORE;

    @Override
    public boolean isValid(int[] input) {
        if(input == null )
            return false;

        if(input.length !=5)
            return false;

        if(countConsecutive(input) == 4)
            return true;
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

    private int countConsecutive(int[] input) {
        int counter = 1;
        int c1 = input.length/2;
        int c2 = c1;
        while(c1 > 0) {
            if(input[c1] - input[c1-1] == 1)
                counter++;
            c1--;
        }

        while(c2 < input.length-1) {
            if(input[c2+1] - input[c2] == 1)
                counter++;
            c2++;
        }
        return counter;
    }
}
