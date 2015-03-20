package SortAndSearch;

import java.util.Random;

public class Sort {
	public static final int SIZE = 5000000;

	public static void main(String[] args) {
		int[] arr = new int[SIZE];
		populateRandom(arr);
		// printArr(arr);
		// Timer bubble = new Timer();
		// bubbleSort(arr.clone());
		// bubble.stop();

		// Timer selection = new Timer();
		// selectionSort(arr.clone());
		// selection.stop();

		Timer insertion = new Timer();
		insertionSort(arr.clone());
		insertion.stop();

		Timer merge = new Timer();
		mergeSort(arr.clone());
		merge.stop();

		// System.out.println(bubble.toString());
		// System.out.println(selection.toString());
		System.out.println(insertion.toString());
		System.out.println(merge.toString());
	}

	@SuppressWarnings("unused")
	public static int[] bubbleSort(int[] unsorted) {
		boolean flag = true;
		int pass = 0;
		int swap = 0;

		while (flag) {
			flag = false; // set flag to false waiting for a possible swap
			for (int j = 0; j < unsorted.length - 1; j++) {
				if (unsorted[j] > unsorted[j + 1]) // change to > for ascending
													// sort
				{
					int temp = unsorted[j]; // swap elements
					unsorted[j] = unsorted[j + 1];
					unsorted[j + 1] = temp;
					flag = true; // shows a swap occurred
					swap++;
				}
			}
			pass++;
		}
		// System.out.println("Passes: " + pass + " Swaps: " + swap);
		return unsorted;
	}

	@SuppressWarnings("unused")
	public static int[] selectionSort(int[] unsorted) {
		int swap = 0;
		int pass = 0;

		for (int i = 0; i < unsorted.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < unsorted.length; j++)
				if (unsorted[j] < unsorted[index])
					index = j;
			int smallerNumber = unsorted[index];
			unsorted[index] = unsorted[i];
			unsorted[i] = smallerNumber;

			swap++;
		}
		pass++;
		// System.out.println("Passes: " + pass + " Swaps: " + swap);
		return unsorted;
	}

	@SuppressWarnings("unused")
	public static int[] insertionSort(int[] unsorted) {
		int swap = 0;
		int pass = 0;

		for (int i = 1; i < unsorted.length; i++) {
			for (int k = i; k >= 1 && unsorted[k] < unsorted[k - 1]; k--) {
				int temp = unsorted[k];
				unsorted[k] = unsorted[k - 1];
				unsorted[k - 1] = k;
				swap++;
			}
		}
		pass++;
		// System.out.println("Passes: " + pass + " Swaps: " + swap);
		return unsorted;
	}

	public static int[] mergeSort(int[] unsorted) {
		if (unsorted.length <= 1) {
			return unsorted;
		}

		int[] left = new int[unsorted.length / 2];
		int[] right = new int[unsorted.length - unsorted.length / 2];
		System.arraycopy(unsorted, 0, left, 0, left.length);
		System.arraycopy(unsorted, left.length, right, 0, right.length);

		mergeSort(right);
		mergeSort(left);

		merge(unsorted, left, right);
		return unsorted;
	}

	public static void merge(int[] unsorted, int[] left, int[] right) {
		int indexLeft = 0; // index into left array
		int indexRight = 0; // index into right array
		int indexUnsorted = 0; // index of the result array

		while (indexLeft < left.length && indexRight < right.length) {
			if (left[indexLeft] < right[indexRight]) {
				unsorted[indexUnsorted] = left[indexLeft];
				indexLeft++;
			} else {
				unsorted[indexUnsorted] = right[indexRight];
				indexRight++;
			}
			indexUnsorted++;
		}
	}

	private static void printArr(int[] inputArr) {
		for (int i = 0; i < inputArr.length; i++) {
			System.out.print(inputArr[i] + ", ");
		}
		System.out.println("\t\t" + inputArr.length + " Length");
	}

	private static void populateRandom(int[] inputArr) {
		Random rand = new Random();
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = rand.nextInt(SIZE * 2);
		}
	}
}
