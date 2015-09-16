package com.popcap.diceonyacht.Categories;

import java.util.Hashtable;

import com.popcap.diceonyacht.utils.Constants;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public class AllDifferent implements Category {

    int successScore = Constants.ALLDIFFERENT_SUCCESSSCORE;

    int failedScore = Constants.ALLDIFFERENT_FAILSCORE;


    @Override
    public boolean isValid(int[] input) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        if(input == null) 
        	return false;
        
        for(int i : input) {
            if(!ht.containsKey(i)) {
                ht.put(i, i);
            } else
                return false;
        }
        return true;
    }

    @Override
    public int getScore(int[] input) {
        if(isValid(input))
            return successScore;
        else
            return failedScore;
    }
}
