/**
 * 
 */
package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abhinandanbhattacharya
 *
 */
public class MultiplyXPlusOne {
	
	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/MultiplyXPlusOne.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiplyXPlusOne multXPlusOne = new MultiplyXPlusOne();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			while ((line = br.readLine()) != null){
				String[] strArray = line.split(",");
				int steps = multXPlusOne.minimalSteps(Integer.valueOf(strArray[0]), Integer.valueOf(strArray[1]));
				System.out.println("The number of steps is : " + steps + " for the values s = " + strArray[0] + " and t = " + strArray[1]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * create a list of the form of a tree which has the values of 2*x + 1 and 3*x + 1 at index 2*index + 1 and 2*index + 2
	 * where index is the value of parent; so we create two child elements at each steps till we have the desired target or
	 * exceed the target
	 * @param s
	 * @param t
	 * @return
	 */
	public int minimalSteps(int s, int t){
//		System.out.println("The input is : " + s + " : " + t);
		//boundary condition
		if(s == t){
			return 0;
		}
		if(t < s){
			return -1;
		}
		List<Integer> treeList = new ArrayList<>();
		treeList.add(s);
		int i = 0;
		int twoXplusOne = s;
		int threeXplusOne = s;		
		while(!treeList.contains(t) || (twoXplusOne > t)){
			int j = 2*i + 1;
			int k = 2*i + 2;			
			twoXplusOne = multiply2XplusOne(treeList.get(i));
			threeXplusOne = multiply3XplusOne(treeList.get(i));
			treeList.add(j, twoXplusOne);
			treeList.add(k, threeXplusOne);
			i++;
//			System.out.println("The list is : " + treeList);
		}
		if(treeList.contains(t)){
//			System.out.println("Found the target element : " + t + " at location : " + treeList.indexOf(t));
			return calculateNumberOfSteps(treeList.indexOf(t));
		}
		return -1;
	}
	
	private int multiply2XplusOne(int value){
		return 2*value + 1;
	}
	
	private int multiply3XplusOne(int value){
		return 3*value + 1;
	}
	
	private int calculateNumberOfSteps(int index){
		int countSteps = 0;
		int parentIndex = index;
		while(parentIndex > 0){
			if(index % 2 == 0){
				parentIndex = (index - 2) / 2;
			}
			else{
				parentIndex = (index - 1) / 2;
			}
			index = parentIndex; // reduce the index to the parent, an easy way to travel up the chain
			countSteps++;
//			System.out.println("Parent Index : " + parentIndex + " Steps : " + countSteps);
		}
		return countSteps;
	}

}
