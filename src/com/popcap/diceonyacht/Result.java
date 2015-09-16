package com.popcap.diceonyacht;

import com.popcap.diceonyacht.Categories.CategoryName;

public class Result {
	
	public int maxScore;
	public CategoryName category;
	
	public Result(){
		maxScore =0;
	}
	
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public CategoryName getCategory() {
		return category;
	}
	public void setCategory(CategoryName category) {
		this.category = category;
	}

}
