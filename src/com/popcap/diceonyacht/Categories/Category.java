package com.popcap.diceonyacht.Categories;

/**
 * Created by Siddhartha on 9/16/2015.
 */
public interface Category {
	
	/**
	 * This is to check for the condition of the category and if true, then return the score
	 * @param input Array of the 5 dice scores from the getScore Method
	 * @return boolean 
	 */

    boolean isValid(int[] input);
    
    /**
     * It check for isValid, then calculate the score and sends the score 
     * @param input Array of the 5 dice scores
     * @return score 
     */

    int getScore(int[] input);
}
