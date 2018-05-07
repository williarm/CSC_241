
//----------------------------------------------------------------------------
// Sorts.java               by Dale/Joyce/Weems                     Chapter 11
//
// Test harness used to run sorting algorithms.
//----------------------------------------------------------------------------

import java.util.*;
import java.text.DecimalFormat;

public class Sorts {
	static final int SIZE = 50; // size of array to be sorted
	static int[] values = new int[SIZE]; // values to be sorted
	static int[] backupValues = new int[SIZE];
	static int swaps = 0;
	static int comparisons = 0;

	static void initValues()
	// Initializes the values array with random integers from 0 to 99.
	{
		Random rand = new Random();
		// for (int index = 0; index < SIZE; index++)
		// values[index] = Math.abs(rand.nextInt()) % 100;
		values[0] = 88;
		values[1] = 49;
		values[2] = 69;
		values[3] = 19;
		values[4] = 03;
		values[5] = 54;
		values[6] = 57;
		values[7] = 83;
		values[8] = 42;
		values[9] = 48;
		values[10] = 92;
		values[11] = 72;
		values[12] = 78;
		values[13] = 10;
		values[14] = 8;
		values[15] = 13;
		values[16] = 46;
		values[17] = 29;
		values[18] = 73;
		values[19] = 90;
		values[20] = 30;
		values[21] = 44;
		values[22] = 80;
		values[23] = 74;
		values[24] = 66;
		values[25] = 60;
		values[26] = 79;
		values[27] = 36;
		values[28] = 05;
		values[29] = 63;
		values[30] = 9;
		values[31] = 97;
		values[32] = 62;
		values[33] = 60;
		values[34] = 21;
		values[35] = 51;
		values[36] = 63;
		values[37] = 83;
		values[38] = 87;
		values[39] = 22;
		values[40] = 8;
		values[41] = 18;
		values[42] = 48;
		values[43] = 41;
		values[44] = 38;
		values[45] = 22;
		values[46] = 58;
		values[47] = 99;
		values[48] = 19;
		values[49] = 94;

		backupValues = values;
	}

	static void resetValues() {
		swaps = 0;
		comparisons = 0;
		values = backupValues;
	}

	static public boolean isSorted()
	// Returns true if the array values are sorted and false otherwise.
	{
		for (int index = 0; index < (SIZE - 1); index++)
			if (values[index] > values[index + 1])
				return false;
		return true;
	}

	static public void swap(int index1, int index2)
	// Precondition: index1 and index2 are >= 0 and < SIZE.
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
		swaps++;
	}

	static public void printValues()
	// Prints all the values integers.
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("The values array is:");
		for (int index = 0; index < SIZE; index++) {
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}

		System.out.println(swaps + " swaps.");
		System.out.println(comparisons + " comparisons.");
		System.out.println();
	}

	/////////////////////////////////////////////////////////////////
	//
	// Selection Sort

	static int minIndex(int startIndex, int endIndex)
	// Returns the index of the smallest value in
	// values[startIndex]..values[endIndex].
	{
		int indexOfMin = startIndex;
		for (int index = startIndex + 1; index <= endIndex; index++) {
			if (values[index] < values[indexOfMin]) {
				indexOfMin = index;
			}
			comparisons++;
		}
		return indexOfMin;
	}

	static void selectionSort()
	// Sorts the values array using the selection sort algorithm.
	{
		int endIndex = SIZE - 1;
		for (int current = 0; current < endIndex; current++) {
			swap(current, minIndex(current, endIndex));
		}
	}

	/////////////////////////////////////////////////////////////////
	//
	// Bubble Sort

	static void bubbleUp(int startIndex, int endIndex)
	// Switches adjacent pairs that are out of order
	// between values[startIndex]..values[endIndex]
	// beginning at values[endIndex].
	{
		for (int index = endIndex; index > startIndex; index--) {
			if (values[index] < values[index - 1]) {
				swap(index, index - 1);
			}
			comparisons++;
		}
	}

	static void bubbleSort()
	// Sorts the values array using the bubble sort algorithm.
	{
		int current = 0;

		while (current < (SIZE - 1)) {
			bubbleUp(current, SIZE - 1);
			current++;
		}
	}

	/////////////////////////////////////////////////////////////////
	//
	// Short Bubble Sort

	static boolean bubbleUp2(int startIndex, int endIndex)
	// Switches adjacent pairs that are out of order
	// between values[startIndex]..values[endIndex]
	// beginning at values[endIndex].
	//
	// Returns false if a swap was made; otherwise, returns true.
	{
		boolean sorted = true;
		for (int index = endIndex; index > startIndex; index--) {
			if (values[index] < values[index - 1]) {
				swap(index, index - 1);
				sorted = false;
			}
			comparisons++;
		}
		return sorted;
	}

	static void shortBubble()
	// Sorts the values array using the bubble sort algorithm.
	// The process stops as soon as values is sorted.
	{
		int current = 0;
		boolean sorted = false;
		while ((current < (SIZE - 1)) && !sorted) {
			sorted = bubbleUp2(current, SIZE - 1);
			current++;
		}
	}

	/////////////////////////////////////////////////////////////////
	//
	// Insertion Sort

	static void insertItem(int startIndex, int endIndex)
	// Upon completion, values[0]..values[endIndex] are sorted.
	{
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		while (moreToSearch && !finished) {
			if (values[current] < values[current - 1]) {
				swap(current, current - 1);
				current--;
				moreToSearch = (current != startIndex);
			} else
				finished = true;
			comparisons++;
		}
	}

	static void insertionSort()
	// Sorts the values array using the insertion sort algorithm.
	{
		for (int count = 1; count < SIZE; count++)
			insertItem(0, count);
	}

	/////////////////////////////////////////////////////////////////
	//
	// Merge Sort

	static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
	// Preconditions: values[leftFirst]..values[leftLast] are sorted.
	// values[rightFirst]..values[rightLast] are sorted.
	//
	// Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.
	{
		int[] tempArray = new int[SIZE];
		int index = leftFirst;
		int saveFirst = leftFirst; // to remember where to copy back

		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (values[leftFirst] < values[rightFirst]) {
				tempArray[index] = values[leftFirst];
				leftFirst++;
			} else {
				tempArray[index] = values[rightFirst];
				rightFirst++;
			}
			index++;
			comparisons++;
		}

		while (leftFirst <= leftLast)
		// Copy remaining items from left half.

		{
			tempArray[index] = values[leftFirst];
			leftFirst++;
			index++;
		}

		while (rightFirst <= rightLast)
		// Copy remaining items from right half.
		{
			tempArray[index] = values[rightFirst];
			rightFirst++;
			index++;
		}

		for (index = saveFirst; index <= rightLast; index++)
			values[index] = tempArray[index];
	}

	static void mergeSort(int first, int last)
	// Sorts the values array using the merge sort algorithm.
	{
		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(first, middle);
			mergeSort(middle + 1, last);
			merge(first, middle, middle + 1, last);

		}

	}

	/////////////////////////////////////////////////////////////////
	//
	// Quick Sort

	static int split(int first, int last) {
		int splitVal = values[first];
		int saveF = first;
		boolean onCorrectSide;

		first++;
		do {
			onCorrectSide = true;
			while (onCorrectSide) // move first toward last
			{
				if (values[first] > splitVal)
					onCorrectSide = false;
				else {
					first++;
					onCorrectSide = (first <= last);
				}
				comparisons++;
			}
			onCorrectSide = (first <= last);
			while (onCorrectSide) // move last toward first
			{
				if (values[last] <= splitVal)
					onCorrectSide = false;
				else {
					last--;
					onCorrectSide = (first <= last);
				}
				comparisons++;
			}

			if (first < last) {
				swap(first, last);
				first++;
				last--;
			}

		} while (first <= last);

		swap(saveF, last);
		return last;
	}

	static void quickSort(int first, int last) {
		if (first < last) {
			int splitPoint;

			splitPoint = split(first, last);
			// values[first]..values[splitPoint - 1] <= splitVal
			// values[splitPoint] = splitVal
			// values[splitPoint+1]..values[last] > splitVal

			quickSort(first, splitPoint - 1);
			quickSort(splitPoint + 1, last);
		}

	}

	/////////////////////////////////////////////////////////////////
	//
	// Heap Sort

	static int newHole(int hole, int lastIndex, int item)
	// If either child of hole is larger than item this returns the index
	// of the larger child; otherwise it returns the index of hole.
	{
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		if (left > lastIndex) {
			// hole has no children
			// comparisons++;
			return hole;
		} else if (left == lastIndex) {
			comparisons++;
			// hole has left child only
			if (item < values[left]) {
				// item < left child
				comparisons++;
				return left;
			} else
				// item >= left child
				return hole;
		} else {
			// hole has two children
			if (values[left] < values[right]) {
				comparisons++;
				// left child < right child
				if (values[right] <= item) {
					comparisons++;
					// right child <= item
					return hole;
				} else
					// item < right child
					return right;
			}

			else {
				// left child >= right child
				if (values[left] <= item) {
					comparisons++;
					// left child <= item
					return hole;
				} else
					// item < left child
					return left;
			}
		}
	}

	static void reheapDown(int item, int root, int lastIndex)
	// Precondition: Current root position is "empty".
	//
	// Inserts item into the tree and ensures shape and order properties.
	{
		int hole = root; // current index of hole
		int newhole; // index where hole should move to

		newhole = newHole(hole, lastIndex, item); // find next hole
		while (newhole != hole) {
			values[hole] = values[newhole]; // move value up
			hole = newhole; // move hole down
			newhole = newHole(hole, lastIndex, item); // find next hole
			// comparisons++;
		}
		values[hole] = item; // fill in the final hole
	}

	static void heapSort()
	// Sorts the values array using the heap sort algorithm.
	{
		int index;
		// Convert the array of values into a heap.
		for (index = SIZE / 2 - 1; index >= 0; index--) {
			reheapDown(values[index], index, SIZE - 1);
		}
		// Sort the array.
		for (index = SIZE - 1; index >= 1; index--) {
			swap(0, index);
			reheapDown(values[0], 0, index - 1);
		}
	}

	/////////////////////////////////////////////////////////////////
	//
	// Main

	public static void main(String[] args) {
		initValues();
		System.out.println("Initial Array");
		printValues();
		System.out.println("values is sorted: " + isSorted());
		System.out.println();

		// make call to sorting method here (just remove //)
		System.out.println("SelectionSort");
		selectionSort();
		printValues();
		resetValues();
		System.out.println("BubbleSort");
		bubbleSort();
		printValues();
		resetValues();
		System.out.println("ShortBubble");
		shortBubble();
		printValues();
		resetValues();
		System.out.println("InsertionSort");
		insertionSort();
		printValues();
		resetValues();
		System.out.println("MergeSort doesn't swap");
		mergeSort(0, SIZE - 1);
		printValues();
		resetValues();
		System.out.println("QuickSort");
		quickSort(0, SIZE - 1);
		printValues();
		resetValues();
		System.out.println("HeapSort");
		heapSort();
		printValues();

		// System.out.println("values is sorted: " + isSorted());
		System.out.println();
	}
}
