package com.sei;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class has three methods to remove duplicate integers from an array of integer.
 * 
 * public int[] removeDuplicatesRetainOriginalOrder(final int[] numbers)
 * Use this method to retain original order of the integer array.
 * Don't use this method if you have memory constraint, as this method internally uses LinkedHashMap.
 * 
 * public int[] removeDuplicatesBySorting(int[] numbers)
 * This is most efficient method to remove duplicate integers from an array of integers.
 * This method doesn't use extra memory space.
 * This method uses java.util.Array.sort() method to sort the array of integers.
 * 
 * public int[] removeDuplicatesWithoutApi(final int[] numbers)
 * This method uses QuickSort algorithm to sort the array of integers then delete duplicate integers.
 *
 * @author Sudhakar
 * @since 1.0
 *
 */
public class DeDup {

	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
			20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
			13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	public static void main(String [] args) {

		int[] uniqueNumbers = null;
		DeDup obj = new DeDup();

		//Remove duplicates using collection framework API and retain original order
		uniqueNumbers = obj.removeDuplicatesRetainOriginalOrder(obj.randomIntegers);
		obj.display(uniqueNumbers);

		//Sort integer array using Array.sort() and remove duplicates
		uniqueNumbers = obj.removeDuplicatesBySorting(obj.randomIntegers);
		obj.display(uniqueNumbers);

		//Sort integer array using quicksort and remove duplicates
		uniqueNumbers = obj.removeDuplicatesWithoutApi(obj.randomIntegers);
		obj.display(uniqueNumbers);

	}

	/**
	 * Use Case: 
	 * Use this method to retain original order of the integer array.
	 * Don't use this method if you have memory constraint, as this method internally uses LinkedHashMap.
	 * 
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	public int[] removeDuplicatesRetainOriginalOrder(final int[] numbers){

		int i = 0;
		int[] uniqueNumbers = null;
		Set<Integer> temp = new LinkedHashSet<Integer>();

		//Add integer array to LinkedHashSet
		for(int num : numbers){
			temp.add(num);
		}

		uniqueNumbers = new int[temp.size()];

		//convert LinkedHashSet to integer array
		for (Iterator<Integer> iterator = temp.iterator(); iterator.hasNext();) {
			uniqueNumbers[i++] = iterator.next();
		}

		return uniqueNumbers;
	}


	/**
	 * Use Case: 
	 * This is most efficient method to remove duplicate integers from an array of integers.
	 * This method doesn't use extra memory space.
	 * This method uses java.util.Array.sort() method to sort the array of integers.
	 * 
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	public int[] removeDuplicatesBySorting(int[] numbers) {

		//Sorting integer array using java.util.Arrays.sort()
		Arrays.sort(numbers);

		return removeDuplicates(numbers);
	}


	/**
	 * Use Case:
	 * This method uses QuickSort algorithm to sort the array of integers then delete duplicate integers.
	 * 
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	public int[] removeDuplicatesWithoutApi(final int[] numbers) {

		//Sort the integer array using QuickSort algorithm
		quicksort(numbers);

		return removeDuplicates(numbers);

	}

	/**
	 * This method removes duplicate integers from an array of integers
	 * 
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	private int[] removeDuplicates(int[] numbers) {

		int[] temp = new int[numbers.length];
		int count = 1;
		int prev;

		temp[0] = prev = numbers[0];

		//Removing duplicate numbers in the integer array
		for (int i = 1; i < numbers.length; ++i) {

			if (numbers[i] != prev) {
				temp[count++] = numbers[i];
			}

			prev = numbers[i];
		}

		//Create new integer array to copy the unique integers.
		final int[] uniqueNumbers = new int[count];
		System.arraycopy(temp, 0, uniqueNumbers, 0, count);

		return uniqueNumbers;
	}


	/**
	 * This method is a starting point for QuickSort algorithm
	 * 
	 * @param numbers an array of integers 
	 */
	private static void quicksort(final int[] numbers) {

		if (numbers.length == 0) {
			return;
		}

		quicksort(numbers, 0, numbers.length - 1);
	}

	/**
	 * Recursive method for QuickSort
	 * 
	 * @param numbers an array of integers
	 * @param low lower limit of array of integers
	 * @param high higher limit of array of integers
	 */
	private static void quicksort(final int[] numbers, final int low, final int high) {

		int i = low;
		int j = high;
		int pivot = numbers[low + (high - low) / 2];

		while (i <= j) {

			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(numbers[i], numbers[j]);
				i++;
				j--;
			}
		}

		if (low < j) {
			quicksort(numbers, low, j);
		}

		if (i < high) {
			quicksort(numbers, i, high);
		}
	}

	/**
	 * Swap two numbers without using third variable
	 * 
	 * @param num1
	 * @param num2
	 */
	private static void swap(int num1, int num2) {

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
	}

	/**
	 * Display integer array on console in a single line
	 * 
	 * @param uniqueNumbers an array of integers
	 */
	private void display(final int[] uniqueNumbers) {

		for (int num : uniqueNumbers) {
			System.out.print(" "+num);
		}

		System.out.println("");
	}
}
