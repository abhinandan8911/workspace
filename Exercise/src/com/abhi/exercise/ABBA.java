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
public class ABBA {
	
	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/ABBA.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ABBA abba = new ABBA();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			while ((line = br.readLine()) != null){
				String[] strArray = line.split(",");
				String result = abba.canObtain(strArray[0], strArray[1]);
				System.out.println(result + " For : " + strArray[0] + " & " + strArray[1]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private String canObtain(String initial, String target){
//		System.out.println(initial + " : " + target);
		boolean result = isPossible(initial, target);
		if(result){
			return "Possible";
		}
		else{
			return "Impossible";
		}
	}
	
	private boolean isPossible(String initial, String target){
		StringBuilder targetBuilder = new StringBuilder(target);
		while(targetBuilder.length() > initial.length()){
			if(targetBuilder.charAt(targetBuilder.length() - 1) == 'A'){
				targetBuilder.deleteCharAt(targetBuilder.length() - 1);
			}
			else{
				targetBuilder.deleteCharAt(targetBuilder.length() - 1);
				targetBuilder = new StringBuilder(targetBuilder.reverse().toString());
			}
		}
		return initial.equals(targetBuilder.toString());
	}

}
