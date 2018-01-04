package com.sei.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class has 3 different methods to remove duplicate from an integer array.
 * 
 * Use setRandomIntegers(int[] randomIntegers) to set the random integers with duplicate
 *
 */
public class DeDup {

	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
			20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
			13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	public int[] getRandomIntegers() {
		return randomIntegers;
	}

	public void setRandomIntegers(int[] randomIntegers) {
		this.randomIntegers = randomIntegers;
	}
	
	public static void main(String [] args) {
		int[] uniqueNumbers;
		DeDup dedup = new DeDup();
		
		System.out.println("Remove duplicates using HashSet");
		uniqueNumbers = dedup.removeDuplicate();
		dedup.display(uniqueNumbers);
		
		System.out.println("\n\nRemove duplicates using Stream");
		uniqueNumbers = dedup.removeDuplicatesWithStream();
		dedup.display(uniqueNumbers);
		
		System.out.println("\n\nRemove duplicates using Parallel Stream");
		uniqueNumbers = dedup.removeDuplicatesWithParallelStream();
		dedup.display(uniqueNumbers);
		
	}

	/**
	 * Use Case: 
	 * Use this method uses HashSet to remove duplicate elements.
	 * 
	 * @return an array of integers
	 */
	private int[] removeDuplicate() {

		//Add int array elements to HashSet
		Set<Integer> temp = new HashSet<Integer>();
		
		for(int num : randomIntegers){
			temp.add(num);
		}

		//convert LinkedHashSet to integer array
		int[] uniqueNumbers = new int[temp.size()];
		int i = 0;
		
		for (Iterator<Integer> iterator = temp.iterator(); iterator.hasNext();) {
			uniqueNumbers[i++] = iterator.next();
		}

		return uniqueNumbers;
	}

	/**
	 * Use Case: 
	 * Use this method to retain original order of the integer array.
	 * 
	 * @return an array of integers
	 */
	private int[] removeDuplicatesWithStream() {
	    return Arrays.stream(randomIntegers).distinct().toArray();
	}
	
	/**
	 * Use Case: 
	 * Use this method to parallel processing of large integer array.
	 * 
	 * @return an array of integers
	 */
	private int[] removeDuplicatesWithParallelStream() {
	    return Arrays.stream(randomIntegers).parallel().distinct().toArray();
	}
	
	/**
	 * Displays array of integers on console.
	 * 
	 * @param array
	 */
	private void display(int[] array) {
		for(int unique: array) {
			System.out.println(unique);
		}
	}
}

