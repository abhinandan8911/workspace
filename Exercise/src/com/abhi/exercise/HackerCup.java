/**
 * 
 */
package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abhinandanbhattacharya
 *
 */
public class HackerCup {
	
	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/input.txt";
	private static int numberOfTestCases = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HackerCup hackerCup = new HackerCup();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
		    String line;
		    int count = 0;
		    while ((line = br.readLine()) != null) {
//		       System.out.println(line);
		       if(count == 0){
		    	   numberOfTestCases = Integer.valueOf(line);
		       }
		       else{
		    	   hackerCup.processString(line, count);
		       }
		       count++;
		    }
		    System.out.println("Number of test cases : " + numberOfTestCases);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void processString(String line, int count){
		Map<String, Integer> charMap = new HashMap<>();
		int countCharH = 0;
		int countCharA = 0;
		int countCharC = 0;
		int countCharK = 0;
		int countCharE = 0;
		int countCharR = 0;
		int countCharU = 0;
		int countCharP = 0;
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == 'H'){
				countCharH++;
			}
			if(line.charAt(i) == 'A'){
				countCharA++;
			}
			if(line.charAt(i) == 'C'){
				countCharC++;
			}
			if(line.charAt(i) == 'K'){
				countCharK++;
			}
			if(line.charAt(i) == 'E'){
				countCharE++;
			}
			if(line.charAt(i) == 'R'){
				countCharR++;
			}
			if(line.charAt(i) == 'U'){
				countCharU++;
			}
			if(line.charAt(i) == 'P'){
				countCharP++;
			}
		}
		charMap.put("H", countCharH);
		charMap.put("A", countCharA);
		charMap.put("C", countCharC);
		charMap.put("K", countCharK);
		charMap.put("E", countCharE);
		charMap.put("R", countCharR);
		charMap.put("U", countCharU);
		charMap.put("P", countCharP);
		System.out.println("Line is - " + line);
		System.out.println("H : " + countCharH + " | A : " + countCharA + " | C : " + countCharC
				+ " | K : " + countCharK + " | E : " + countCharE + " | R : " + countCharR + " | U : " + countCharU + " | P : " + countCharP);
		int words = countWords(charMap);
		System.out.println("Case #" + count + ":" + words);
	}
	
	private int countWords(Map<String, Integer> charMap){
		int word = 0;
		if(charMap.get("H") > 0){
			int countH = charMap.get("H");
			word = countH;
			if(charMap.get("A") > 0){
				int countA = charMap.get("A");
				if(countA <= countH){
					word = countA;
				}
				if(charMap.get("C") > 0){
					int countC = charMap.get("C");
					countC = countC/2;
					if(countC <= countA){
						word = countC;
					}
					if(charMap.get("K") > 0){
						int countK = charMap.get("K");
						if(countK <= countC){
							word = countK;
						}
						if(charMap.get("E") > 0){
							int countE = charMap.get("E");
							if(countE <= countK){
								word = countE;
							}
							if(charMap.get("R") > 0){
								int countR = charMap.get("R");
								if(countR <= countE){
									word = countR;
								}
								if(charMap.get("U") > 0){
									int countU = charMap.get("U");
									if(countU <= countR){
										word = countU;
									}
									if(charMap.get("P") > 0){
										int countP = charMap.get("P");
										if(countP <= countU){
											word = countP;
										}
									}
									else{
										word = 0;
									}
								}
								else{
									word = 0;
								}
							}
							else{
								word = 0;
							}
						}
						else{
							word = 0;
						}
					}
					else{
						word = 0;
					}
				}
				else{
					word = 0;
				}
			}
			else{
				word = 0;
			}
		}
		else{
			word = 0;
		}

		return word;
	}

}