package com.popcap.diceonyacht;
import java.lang.reflect.Method;
import java.util.Arrays;

import  com.popcap.diceonyacht.Categories.*;

/**
 * Created by Siddhartha on 9/16/2015.
 */

public class Main {
    public static void main(String[] args) {

        int[] input = new int[] {1,6,8,8,5};
        printArray(input);
        Arrays.sort(input);
        System.out.println("getScore :"+getScore(input, CategoryName.Eights));
        System.out.println("getSuggestions :"+ getNewSuggestions(input));

    }
        
    public static int getScore(int[] input, CategoryName categoryName) {
    	Class<?> category;
    	int score = 0;
		try {			
			category = Class.forName("com.popcap.diceonyacht.Categories."+categoryName.toString());
			Object instance = category.newInstance();
			Method getScore = category.getDeclaredMethod("getScore",input.getClass() );
			// System.out.println(getScor);
	    	score = (Integer) getScore.invoke(instance,input);
			} 
		catch (Exception e) {			
			e.printStackTrace();
		}    	
        return score;
    }

 
    public static String getNewSuggestions(int[] input){
    	Result resultObj = new Result();    	
    	for(CategoryName cn: CategoryName.values()){
    		resultObj = getResult(resultObj, cn, input);
    	}
		return resultObj.category.toString();
    	
    }
    

    
    private static Result getResult(Result result, CategoryName categoryName, int[] input){
    	int currentScore = 0;
    	Class<?> category;
    	try {			
			category = Class.forName("com.popcap.diceonyacht.Categories."+categoryName.toString());
			Object instance = category.newInstance();
			Method getScore = category.getDeclaredMethod("getScore",input.getClass() );
			// System.out.println(getScor);
			currentScore = (Integer) getScore.invoke(instance,input);
			} catch (Exception e) {			
			e.printStackTrace();
		}
    	
    	if(result.maxScore < currentScore){
    		result.maxScore = currentScore;
    		result.category = categoryName;
    	}    	
    	return result;    	
    }

    public static void printArray(int[] input) {    	
    	System.out.print("Array {");
    	for(int i : input){
    		System.out.print(i + ",");
    	}
    	System.out.print("}");
    	System.out.println();		
	}
    
    public static int getScore(int[] input, Category category) {
        return category.getScore(input);
    }


}

