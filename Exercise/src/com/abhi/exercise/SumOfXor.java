/**
 * 
 */
package com.abhi.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author abhinandanbhattacharya
 *
 */
public class SumOfXor {

	private static final String FILE_PATH = "/Users/abhinandanbhattacharya/Documents/workspace/SumOfXor.txt";
	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SumOfXor sumOfXor = new SumOfXor();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			String inputLine;
			while ((line = br.readLine()) != null){
				inputLine = line;
				line = line.replace("{", "");
				line = line.replace("}", "");
				String[] strArray = line.split(",");
				long[] inputCards = new long[strArray.length];
				int counter = 0;
				for(String strElem : strArray){
					inputCards[counter++] = Long.valueOf(strElem.trim());
				}
				long result = sumOfXor.maxSum(inputCards);
				System.out.println("For the input : " + inputLine + " the max sum is : " + result);
			}
		}

	}
	
	public long maxSum(long[] x){
		Arrays.sort(x);
		List<Long> listOne = new ArrayList<>();
		List<Long> listTwo = new ArrayList<>();
		Set<Integer> takenIndexList = new TreeSet<>();
		int selectedIndex = 0;
		while(selectedIndex > -1){
			long maxXor = xorOfListElements(listOne);
			selectedIndex = -1;
			for(int j = x.length -1; j >= 0; j--){
//				System.out.println("Max XOR is : " + maxXor);
				if(takenIndexList.contains(j)){
					continue;
				}
				long xorValue = x[j] ^ maxXor;
				if(xorValue >= maxXor){
					maxXor = xorValue;
					selectedIndex = j;
				}
			}
//			System.out.println("Selected Index is : " + selectedIndex);
			if(selectedIndex > -1){
				listOne.add(x[selectedIndex]);
				takenIndexList.add(selectedIndex);				
			}
		}
		

		
		for(int i=0; i < x.length; i++){
			if(!takenIndexList.contains(i)){
				listTwo.add(x[i]);
			}
		}

//		System.out.println("List One is : ");
//		for(long elements : listOne){
//			System.out.print(elements + ",");
//		}
//		System.out.println("\n");
//		System.out.println("List Two is : ");
//		for(long elements : listTwo){
//			System.out.print(elements + ",");
//		}
//		System.out.println("\n");
		return xorOfListElements(listOne) + xorOfListElements(listTwo);
	}
	
	private long xorOfListElements(List<Long> inputList){
		long xor = 0L;
		if(inputList.isEmpty()){
			return 0L;
		}
		for(long elemValue : inputList){
			xor ^= elemValue;
		}
		return xor;
	}

}
