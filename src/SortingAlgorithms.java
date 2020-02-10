public class SortingAlgorithms {

	static long comparisons = 0;
	static long swap = 0;
	static long arrayAccess = 0;

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++) {
				comparisons++;
				arrayAccess += 2;
				if (arr[j] > arr[j + 1]) {
					swap++;
					// swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					arrayAccess += 4;
				}
			}
	}

	static long getSwaps() {
		long s = 0;
		s = swap;
		swap = 0;
		return s;
	}

	static long getComparisons() {
		long c = 0;
		c = comparisons;
		comparisons = 0;
		return c;
	}

	static long getarrayAccess() {
		long a = 0;
		a = arrayAccess;
		arrayAccess = 0;
		return a;
	}

	// **Selection Sort**
	// Citation: https://www.geeksforgeeks.org/selection-sort/ by Rajat Mishra
	static void selectionSort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				comparisons++;
				arrayAccess += 2;
				if (arr[j] < arr[min_idx])
					min_idx = j;
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
			swap += 4;
		}
	}

	// **Insertion Sort**
	// Citation: https://www.geeksforgeeks.org/insertion-sort/ by Rajat Mishra
	static void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			comparisons++;
			arrayAccess++;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				swap++;
				arrayAccess += 2;
				j = j - 1;
			}
			arr[j + 1] = key;
			swap++;
			arrayAccess++;
		}
	}

	// **Merge Sort**
	// Citation: https://www.geeksforgeeks.org/merge-sort/ by Rajat Mishra

	static void mergeSort(int[] array) {
		if (array.length > 1) {
			// split array into two halves
			int[] left = leftHalf(array);
			int[] right = rightHalf(array);

			// recursively sort the two halves
			mergeSort(left);
			mergeSort(right);

			// merge the sorted halves into a sorted whole
			merge(array, left, right);
		}
	}

	// Returns the first half of the given array.
	public static int[] leftHalf(int[] array) {
		int size1 = array.length / 2;
		int[] left = new int[size1];
		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
			swap++;
			arrayAccess += 2;
		}
		return left;
	}

	// Returns the second half of the given array.
	public static int[] rightHalf(int[] array) {
		int size1 = array.length / 2;
		int size2 = array.length - size1;
		int[] right = new int[size2];
		for (int i = 0; i < size2; i++) {
			right[i] = array[i + size1];
			swap++;
			arrayAccess += 2;
		}
		return right;
	}

	// Merges the given left and right arrays into the given
	// result array. Second, working version.
	// pre : result is empty; left/right are sorted
	// post: result contains result of merging sorted lists;
	public static void merge(int[] result, int[] left, int[] right) {
		int i1 = 0; // index into left array
		int i2 = 0; // index into right array

		for (int i = 0; i < result.length; i++) {
			comparisons++;
			arrayAccess++;
			if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1]; // take from left
				swap++;
				arrayAccess += 2;
				i1++;
			} else {
				result[i] = right[i2]; // take from right
				swap++;
				arrayAccess += 2;
				i2++;
			}
		}
	}

	// Quick Sort
	// Citation: https://www.geeksforgeeks.org/quick-sort/ by Rajat Mishra

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot

			comparisons++;
			arrayAccess++;
			;
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				swap++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				arrayAccess += 4;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		swap++;
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		arrayAccess += 4;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// **Heap Sort**
	// Citation: https://www.geeksforgeeks.org/merge-sort/ by Rajat Mishra

	static void heapSort(int arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			swap++;
			arr[0] = arr[i];
			arr[i] = temp;
			arrayAccess += 4;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	static void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		comparisons++;
		arrayAccess += 2;
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		comparisons++;
		arrayAccess += 2;
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			swap++;
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			arrayAccess += 4;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	// **Counting Sort**
	// Citation: https://venus.cs.qc.cuny.edu/~mfried/cs313/code/Sorting.java by
	// Michael Fried

	static void countingSort(int[] a, int k) {
		int[] output = new int[a.length];
		arrayAccess++;
		int[] count = new int[k];
		arrayAccess++;
		for (int i = 0; i < a.length; ++i) { // Count the occurrences of each integer
			++count[a[i]];
			arrayAccess += 2;
		}
		for (int i = 1; i < k; ++i) { // Compute the number of elements less than each integer
			count[i] += count[i - 1];
			arrayAccess += 2;
		}
		for (int i = a.length - 1; i >= 0; --i) { // Copy each element to the correct spot in the output array
			output[--count[a[i]]] = a[i];
			arrayAccess += 4;
		}
		for (int i = 0; i < a.length; ++i) { // Copy the elements back to array a
			a[i] = output[i];
			arrayAccess += 2;
		}
	}

	// **Radix Sort**
	// Citation: https://venus.cs.qc.cuny.edu/~mfried/cs313/code/Sorting.java by
	// Michael Fried

	static void radixSort(int[] a) {
		int[] b = new int[a.length];
		stablesort(a, b, 0); // Sort by the least significant digit
		stablesort(b, a, 8);
		stablesort(a, b, 16);
		stablesort(b, a, 24); // Sort by the most significant digit
	}

	// Sorts by the specified 8-bit digit (using counting sort)
	private static void stablesort(int[] a, int[] b, int shift) {
		int[] count = new int[0x100];
		for (int i = 0; i < a.length; ++i) { // Count the occurrences of each integer
			++count[(a[i] >> shift) & 0xFF];
			arrayAccess+=2;
		}
		for (int i = 1; i < 0x100; ++i) {// Compute the number of elements less than each integer
			count[i] += count[i - 1];
			arrayAccess += 2;
		}
		for (int i = a.length - 1; i >= 0; --i) { // Copy each element to the correct spot in the output array
			b[--count[(a[i] >> shift) & 0xFF]] = a[i];
			arrayAccess += 4;
		}
	}

	// **Bucket Sort**
	// Citation: https://www.javacodex.com/Sorting/Bucket-Sort

	public static void bucketSort(int[] a, int maxVal) {
		int[] bucket = new int[maxVal + 1];
		arrayAccess++;

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
			arrayAccess++;
		}

		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
			arrayAccess += 2;
		}

		int outPos = 0;
		arrayAccess += 2;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				a[outPos++] = i;
				arrayAccess++;
			}
		}
	}

	// **Cocktail Sort**
	// Citation: https://www.geeksforgeeks.org/cocktail-sort/

	static void cocktailSort(int a[]) {
		boolean swapped = true;
		int start = 0;
		int end = a.length;

		while (swapped == true) {
			// reset the swapped flag on entering the
			// loop, because it might be true from a
			// previous iteration.
			swapped = false;

			// loop from bottom to top same as
			// the bubble sort
			for (int i = start; i < end - 1; ++i) {
				comparisons++;
				arrayAccess += 2;
				if (a[i] > a[i + 1]) {
					swap++;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					arrayAccess += 4;
					swapped = true;
				}
			}

			// if nothing moved, then array is sorted.
			if (swapped == false)
				break;

			// otherwise, reset the swapped flag so that it
			// can be used in the next stage
			swapped = false;

			// move the end point back by one, because
			// item at the end is in its rightful spot
			end = end - 1;

			// from top to bottom, doing the
			// same comparison as in the previous stage
			for (int i = end - 1; i >= start; i--) {
				comparisons++;
				arrayAccess += 2;
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					arrayAccess += 4;
					swapped = true;
				}
			}

			// increase the starting point, because
			// the last stage would have moved the next
			// smallest number to its rightful spot.
			start = start + 1;
		}
	}

	// Print array
	static void printArray(int[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(anArray[i]);
		}
	}

	// end
}
