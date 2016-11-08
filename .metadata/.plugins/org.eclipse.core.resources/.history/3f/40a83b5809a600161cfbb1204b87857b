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
public class ExploringNumbers {

	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/ExploringNumbers.txt";
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ExploringNumbers exploringNumbers = new ExploringNumbers();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			while ((line = br.readLine()) != null){
				int input = Integer.valueOf(line);
				int steps = exploringNumbers.numberOfSteps(input);
				System.out.println("The number of steps for input : " + input + " is : " + steps);
			}
		}

	}
	
	public int numberOfSteps(int n){
		int numberOfSteps = 0;
		int initialNumber = n;
		while(numberOfSteps < n){
			numberOfSteps++;
			if(isPrime(initialNumber)){
				return numberOfSteps;
			}
			else{
				initialNumber = nextNumber(initialNumber);
			}
		}
		return -1;
	}
	
	private int nextNumber(int previousNumber){
		int nextNumber = 0;
		while(previousNumber > 0){
			int digit = previousNumber % 10;
			nextNumber += Math.pow(digit, 2);
			previousNumber /= 10;
		}
		return nextNumber;
	}

	private boolean isPrime(int number){
		if(number == 1){
			return false;
		}
		if(number % 2 == 0){
			return false;
		}
		for(int i = 3; i*i <= number; i += 2){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}
}
