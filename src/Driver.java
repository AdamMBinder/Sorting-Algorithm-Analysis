
// Author: Adam Binder
// Description: CSCI 323 Project 1 - An implementation of 10 sorting algorithms that tracks execution time and 
// number of operations required for a given run.
// Date last modified: 7/21/19

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JOptionPane;

public class Driver {

	static Random rand = new Random();

	// Generates random arrays, each with n arraySize elements
	static int[] testArray(int arraySize) {
		int[] randomArray = new int[arraySize];

		// Fill the arrays with values
		for (int i = 0; i < arraySize; ++i) {
			randomArray[i] = rand.nextInt(1000000);

		}

		return randomArray;

	}

	public static void main(String[] args) {
		long[] comparisons = new long[50];
		long[] swaps = new long[50];
		long[] arrayAccess = new long[50];
		double startTime, endTime = 0;

		double[] totalTime = new double[50];

		int[] array = testArray(10); // create random array of size n

		// Bubble Sort 10 size
		System.out.println("BUBBLE SORT 10-size array iteration:\n");
		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bubbleSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUBBLE SORT 100-size array iteration:\n");

		// Bubble Sort 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bubbleSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUBBLE SORT 1000-size array iteration:\n");

		// Bubble Sort 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bubbleSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUBBLE SORT 10000-size array iteration:\n");

		// Bubble Sort 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bubbleSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUBBLE SORT 100000-size array iteration:\n");

		// Bubble Sort 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bubbleSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "bubbleSort.csv"); // save data into .csv file
		System.out.println("Data saved in bubbleSort.csv\n");

		// *SELECTION SORT*
		// 10 size
		System.out.println("SELECTION SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.selectionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nSELECTION SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.selectionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nSELECTION SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.selectionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nSELECTION SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.selectionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nSELECTION SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.selectionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "selectionSort.csv"); // save data into .csv file
		System.out.println("Data saved in selectionSort.csv\n");

		// *INSERTION SORT*
		// 10 size
		System.out.println("INSERTION SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.insertionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nINSERTION SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.insertionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nINSERTION SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.insertionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nINSERTION SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.insertionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nINSERTION SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.insertionSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "insertionSort.csv"); // save data into .csv file
		System.out.println("Data saved in insertionSort.csv\n");

		// *MERGE SORT*
		// 10 size
		System.out.println("MERGE SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.mergeSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nMERGE SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.mergeSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nMERGE SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.mergeSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nMERGE SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.mergeSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nMERGE SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.mergeSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "mergeSort.csv"); // save data into .csv file
		System.out.println("Data saved in mergeSort.csv\n");

		// *QUICK SORT*
		// 10 size
		System.out.println("QUICK SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.quickSort(array, 0, array.length - 1); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nQUICK SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.quickSort(array, 0, array.length - 1); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nQUICK SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.quickSort(array, 0, array.length - 1); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nQUICK SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.quickSort(array, 0, array.length - 1); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nQUICK SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.quickSort(array, 0, array.length - 1); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "quickSort.csv"); // save data into .csv file
		System.out.println("Data saved in quickSort.csv\n");

		// *HEAP SORT*
		// 10 size
		System.out.println("HEAP SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.heapSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nHEAP SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.heapSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nHEAP SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.heapSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nHEAP SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.heapSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nHEAP SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.heapSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "heapSort.csv"); // save data into .csv file
		System.out.println("Data saved in heapSort.csv\n");

		// *COUNTING SORT*
		// 10 size
		System.out.println("COUNTING SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.countingSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOUNTING SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.countingSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOUNTING SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.countingSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOUNTING SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.countingSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOUNTING SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.countingSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "countingSort.csv"); // save data into .csv file
		System.out.println("Data saved in countingSort.csv\n");

		// *RADIX SORT*
		// 10 size
		System.out.println("RADIX SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.radixSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nRADIX SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.radixSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nRADIX SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.radixSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nRADIX SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.radixSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nRADIX SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.radixSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "radixSort.csv"); // save data into .csv file
		System.out.println("Data saved in radixSort.csv\n");

		// *BUCKET SORT*
		// 10 size
		System.out.println("BUCKET SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bucketSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUCKET SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bucketSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUCKET SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bucketSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUCKET SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bucketSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nBUCKET SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.bucketSort(array, 1000000); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "bucketSort.csv"); // save data into .csv file
		System.out.println("Data saved in bucketSort.csv\n");

		// *COCKTAIL SORT*
		// 10 size
		System.out.println("COCKTAIL SORT 10-size array iteration:\n");

		for (int i = 1; i <= 10; i++) {
			array = testArray(10); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.cocktailSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + i + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOCKTAIL SORT 100-size array iteration:\n");

		// 100 size
		for (int i = 11; i <= 20; i++) {
			array = testArray(100); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.cocktailSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 10) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOCKTAIL SORT 1000-size array iteration:\n");

		// 1000 size
		for (int i = 21; i <= 30; i++) {
			array = testArray(1000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.cocktailSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 20) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOCKTAIL SORT 10000-size array iteration:\n");

		// 10000 size
		for (int i = 31; i <= 40; i++) {
			array = testArray(10000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.cocktailSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 30) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		System.out.println("\nCOCKTAIL SORT 100000-size array iteration:\n");

		// 100000 size
		for (int i = 41; i <= 50; i++) {
			array = testArray(100000); // create random array of size n
			startTime = System.currentTimeMillis(); // get start time
			SortingAlgorithms.cocktailSort(array); // do sort
			endTime = System.currentTimeMillis(); // get end time
			totalTime[i - 1] = (endTime - startTime) / 1000; // calculate overall execution

			comparisons[i - 1] = SortingAlgorithms.getComparisons(); // get # of comparisons
			swaps[i - 1] = SortingAlgorithms.getSwaps(); // get # of swaps
			arrayAccess[i - 1] = SortingAlgorithms.getarrayAccess(); // get # of array accesses

			System.out.println("Iteration " + (i - 40) + " - Average runtime in seconds: " + totalTime[i - 1] + " with "
					+ comparisons[i - 1] + " comparisons and " + swaps[i - 1] + " swaps" + " for a total of "
					+ arrayAccess[i - 1] + " array accesses.");
		}

		saveRecord(totalTime, comparisons, swaps, arrayAccess, "cocktailSort.csv"); // save data into .csv file
		System.out.println("Data saved in cocktailSort.csv\n");
	}

	// Print results in file

	public static void saveRecord(double totalTime[], long comparisons[], long swaps[], long arrayAccess[],
			String filepath) {
		try {
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println("Execution Time in Seconds");
			pw.print("\nn,Iter 1,Iter 2,Iter 3,Iter 4,Iter 5,Iter 6,Iter 7,Iter 8,Iter 9,Iter 10,Avg.");

			pw.print("\n10,");
			for (int i = 0; i < 10; i++) {
				pw.print(totalTime[i] + ",");
			}

			pw.print("\n100,");

			for (int i = 10; i < 20; i++) {
				pw.print(totalTime[i] + ",");
			}

			pw.print("\n1000,");

			for (int i = 20; i < 30; i++) {
				pw.print(totalTime[i] + ",");
			}

			pw.print("\n10000,");

			for (int i = 30; i < 40; i++) {
				pw.print(totalTime[i] + ",");
			}

			pw.print("\n100000,");

			for (int i = 40; i < 50; i++) {
				pw.print(totalTime[i] + ",");
			}

			pw.println("\n\nTotal Comparisons of Elements");
			pw.print("\nn,Iter 1,Iter 2,Iter 3,Iter 4,Iter 5,Iter 6,Iter 7,Iter 8,Iter 9,Iter 10,Avg.");

			pw.print("\n10,");
			for (int i = 0; i < 10; i++) {
				pw.print(comparisons[i] + ",");
			}

			pw.print("\n100,");

			for (int i = 10; i < 20; i++) {
				pw.print(comparisons[i] + ",");
			}

			pw.print("\n1000,");

			for (int i = 20; i < 30; i++) {
				pw.print(comparisons[i] + ",");
			}

			pw.print("\n10000,");

			for (int i = 30; i < 40; i++) {
				pw.print(comparisons[i] + ",");
			}

			pw.print("\n100000,");

			for (int i = 40; i < 50; i++) {
				pw.print(comparisons[i] + ",");
			}

			pw.println("\n\nTotal Number of Array Accesses");
			pw.print("\nn,Iter 1,Iter 2,Iter 3,Iter 4,Iter 5,Iter 6,Iter 7,Iter 8,Iter 9,Iter 10,Avg.");

			pw.print("\n10,");
			for (int i = 0; i < 10; i++) {
				pw.print(arrayAccess[i] + ",");
			}

			pw.print("\n100,");

			for (int i = 10; i < 20; i++) {
				pw.print(arrayAccess[i] + ",");
			}

			pw.print("\n1000,");

			for (int i = 20; i < 30; i++) {
				pw.print(arrayAccess[i] + ",");
			}

			pw.print("\n10000,");

			for (int i = 30; i < 40; i++) {
				pw.print(arrayAccess[i] + ",");
			}

			pw.print("\n100000,");

			for (int i = 40; i < 50; i++) {
				pw.print(arrayAccess[i] + ",");
			}

			pw.flush();
			pw.close();

		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Data not saved");
		}
	}
}
