package chap2.sec3;

import java.util.Arrays;

import common.Util;

/**
 * Merge sort does log n merge steps because each merge step doubles the list
 * size.  The base of log n is 2 if omitted. If n is 8 (array's size), we merge from 
 * 8 one-element arrays to 4 two-element arrays to 2 four-element arrays to one 8-element array. 
 * log 8 = 3 - we got 3 merges. in addition, id does n work for each merge step because it
 * must look for every item. So it runs in O(n log n) Performance O(n log n) is
 * the same for small or large arrays, best case or worst case. Insertion sort
 * best case: O(n); worst case: O(n square)
 */
public class MergeSort {

	public static int[] sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * 
	 * @param arr array to sort
	 * @param p   lower index
	 * @param r   upper index
	 *            mergeSort(arr,0,5)->mergeSort(arr,0,2)->mergeSort(arr,0,1)->mergeSort(arr,0,0)
	 * 
	 *            mergeSort(arr,3,5)->mergeSort(arr,5,5)->
	 *            
	 * { 5, 2, 4, 6, 3, 1 };            
	 */
	private static void mergeSort(int[] arr, int p, int r) {
		// Base case
		if (p == r) {
			return;
		}
		// Middle index
		int q = (p + r) / 2;
		// a)
		// [5, 2, 4, 6, 3, 1] p=0, q=2, r=5
		// [5, 2, 4, 6, 3, 1] p=0, q=1, r=2
		// [5, 2, 4, 6, 3, 1] p=0, q=0, r=1
		
		// g)
		// [2, 4, 5, 6, 3, 1] p=3, q=4, r=5
		// [2, 4, 5, 6, 3, 1] p=3, q=3, r=4
		mergeSort(arr, p, q);
		
		// b)
		// [5, 2, 4, 6, 3, 1] p=0, q=0, r=1 continue where we left
		
		// d)
		// [2, 5, 4, 6, 3, 1] p=0, q=1, r=2
		
		// f)
		// [2, 4, 5, 6, 3, 1] p=0, q=2, r=5
		
		// h)
		// [2, 4, 5, 6, 3, 1] p=3, q=3, r=4
		
		// j)
		// [2, 4, 5, 3, 6, 1] p=3, q=4, r=5
		mergeSort(arr, q + 1, r);
		
		merge(arr, p, q, r);

	}

//	arr is an array and p, q, and r are indices into the array
//	such that p <= q < r. The procedure assumes that the subarrays arr[p..q] and
//	arr[q+1, r] are in sorted order. It merges them to form a single sorted subarray
//	that replaces the current subarray arr[p..r]
	private static void merge(int[] arr, int p, int q, int r) {
		// c)
		// [5, 2, 4, 6, 3, 1] p=0, q=0, r=1
		
		// e)
		// [2, 5, 4, 6, 3, 1] p=0, q=1, r=2
		
		// i)
		// [2, 4, 5, 6, 3, 1] p=3, q=3, r=4
		
		// k)
		// [2, 4, 5, 3, 6, 1] p=3, q=4, r=5
		// [2, 4, 5, 1, 3, 6] p=0, q=2, r=5
		
		int n1 = q - p + 1;
		int n2 = r - q;
		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[p + i];
		}
		for (int j = 0; j < n2; j++) {
			right[j] = arr[q + 1 + j];
		}
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i = i + 1;
			} else {
				arr[k] = right[j];
				j = j + 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 4, 6, 3, 1 };
		int[] sorted = sort(arr);
		Util.printArray(sorted);
	}

}
