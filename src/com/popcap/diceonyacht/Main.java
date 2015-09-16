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
			} catch (Exception e) {			
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
    
//    public static String getSuggestions(int[] input) {
//        
//        Result resultObj = new Result();
//        if(new AllDifferent().isValid(input)) {
//            return AllDifferent.class.getSimpleName();
//        } else if(new AllSame().isValid(input)) {
//            return AllSame.class.getSimpleName();
//        }
//        else{        
//        resultObj = getResult(resultObj,new SmallStraight(), input);
//        resultObj = getResult(resultObj,new LargeStraight(), input);
//        resultObj = getResult(resultObj,new FullHouse(), input);
//        resultObj = getResult(resultObj,new FourKind(), input);
//        resultObj = getResult(resultObj,new ThreeKind(), input);
//        resultObj = getResult(resultObj,new Chance(), input);
//        resultObj = getResult(resultObj,new Ones(), input);
//        resultObj = getResult(resultObj,new Twos(), input);
//        resultObj = getResult(resultObj,new Threes(), input);
//        resultObj = getResult(resultObj,new Fours(), input);
//        resultObj = getResult(resultObj,new Fives(), input);
//        resultObj = getResult(resultObj,new Sixes(), input);
//        resultObj = getResult(resultObj,new Sevens(), input);
//        resultObj = getResult(resultObj,new Eights(), input);
//        }
//       // System.out.println("getMaxScore :"+resultObj.maxScore);
//        return resultObj.category.getClass().getSimpleName();
//    }
    
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
    
//    private static Result getResult(Result result, Category catogory, int[] input){
//    	int currentScore = catogory.getScore(input);
//    	if(result.maxScore < currentScore){
//    		result.maxScore = currentScore;
//    		result.category = catogory;
//    	}    	
//    	return result;    	
//    }

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

