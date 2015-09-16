package com.popcap.diceonyacht.Categories;

public class Chance implements Category {

	@Override
	public boolean isValid(int[] input) {
		if(input == null)
			return false;
		return true;
	}

	@Override
	public int getScore(int[] input) {
		int score =0;
		for(int i: input){
			score =score+i;
		}
		return score;
	}

}
