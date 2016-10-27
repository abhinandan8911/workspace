package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerCupOptimized {
	
	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/input.txt";
	private static int numberOfTestCases = 0;
	
	public static void main(String[] args) {
		HackerCupOptimized hackerCupOpt = new HackerCupOptimized();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
		    String line;
		    int count = 0;
		    while ((line = br.readLine()) != null) {
//		       System.out.println(line);
		       if(count == 0){
		    	   numberOfTestCases = Integer.valueOf(line);
		       }
		       else{
		    	   hackerCupOpt.processString(line, count);
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
		List<Integer> charCountList = new ArrayList<>(); 
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
		
		charCountList.add(countCharH);
		charCountList.add(countCharA);
		charCountList.add(countCharC/2);
		charCountList.add(countCharK);
		charCountList.add(countCharE);
		charCountList.add(countCharR);
		charCountList.add(countCharU);
		charCountList.add(countCharP);

		System.out.println("Line is - " + line);
		System.out.println("H : " + countCharH + " | A : " + countCharA + " | C : " + countCharC
				+ " | K : " + countCharK + " | E : " + countCharE + " | R : " + countCharR + " | U : " + countCharU + " | P : " + countCharP);
		Collections.sort(charCountList);
		int words = charCountList.get(0);
		System.out.println("Case #" + count + ":" + words);
	}	

}
