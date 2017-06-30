package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChefChottu {

	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/chef_chottu.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		List<int[]> inputList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			while ((line = br.readLine()) != null){
				String[] strArray = line.split(",");
				int[] tempArray = new int[strArray.length];
				int i = 0;
				for(String strElem : strArray){					
					tempArray[i++] = Integer.valueOf(strElem);
				}
				inputList.add(tempArray);
			}			
		}
		ChefChottu instance = new ChefChottu();
		instance.arrange(inputList);
	}

	private void arrange(List<int[]> inputList) {
		for(int[] intArray : inputList){
			int count = 0;
			while(needsSwap(intArray)){
				swap(intArray);
				count++;
			}
			System.out.println("For the List - " + intArray + " time taken is - " + count + " seconds.");
		}		
	}

	private boolean needsSwap(int[] intArray) {
		int length = intArray.length;
		for(int i=0; i < length; i++){
			if(i < length - 1 && intArray[i] == 0 && intArray[i+1] == 1){
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	private void swap(int[] intArray) {
		int length = intArray.length;
		for(int i=0; i < length;){
			if(i < length - 1 && intArray[i] == 0 && intArray[i+1] == 1){
				int temp = intArray[i];
				intArray[i] = intArray[i+1];
				intArray[i+1] = temp;
				i += 2;
			}
			else{
				i += 1;
			}
		}				
	}
}
