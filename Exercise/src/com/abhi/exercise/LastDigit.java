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
public class LastDigit {
	
	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/LastDigit.txt";

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LastDigit lastDigit = new LastDigit();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			while ((line = br.readLine()) != null){
				Long parsedInput = Long.valueOf(line);
				long result = lastDigit.findX(parsedInput);
				System.out.println("The result is : " + result);
			}
			
		}

	}
	
	public long findX(long S){
		return binarySearch(1L,S,S);
	}
	
	private long recursiveSum(long initial){
		long result = 0L;
		while(initial > 0){
			result += initial;
			initial /= 10;
		}
		return result;
	}
	
	private long binarySearch(long low, long high, long target){
		while(low <= high){
			long mid = (low + high)/2;
			if(recursiveSum(mid) < target){
				low = mid + 1;
			}
			else{
				if(recursiveSum(mid) > target){
					high = mid - 1;
				}
				else{
					return mid;
				}
			}	
		}
		return -1L;
	}

}
