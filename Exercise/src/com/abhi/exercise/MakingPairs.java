/**
 * 
 */
package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author abhinandanbhattacharya
 *
 */
public class MakingPairs {

	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/MakingPairs.txt";
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MakingPairs makingPairs = new MakingPairs();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			String inputLine;
			while ((line = br.readLine()) != null){
				inputLine = line;
				line = line.replace("{", "");
				line = line.replace("}", "");
				String[] strArray = line.split(",");
				int[] card = new int[strArray.length];
				int counter = 0;
				for(String strElem : strArray){
					card[counter++] = Integer.valueOf(strElem.trim());
				}
				int result = makingPairs.get(card);
				System.out.println("The number of pairs for: " + inputLine + " is : " + result);
			}
		}

	}
	
	public int get(int[] card){
		int[] newCard = new int[card.length];
		int count = 0;
		for(int elem : card){
			elem /= 2;
			newCard[count++] = elem;
		}
		return sumOfIntArray(newCard);
	}
	
	private int sumOfIntArray(int[] array){
		int sum = 0;
		for(int element : array){
			sum += element;
		}
		return sum;
	}

}
