package chap2.sec3;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
//	@Complexity("O(n*lg(n))")
	private static void mergeSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
//	@Complexity("O(n)")
	private static void merge(int[] arr, int p, int q, int r) {
		// p = 0, q = 0, r = 1 -> merging [4] and [7] to [4, 7, 9, 3]
		// p = 2, q = 2, r = 3 -> merging [9] and [3] to [4, 7, 3, 9]
		// p = 0, q = 1, r = 3 -> merging [4, 7] and [3, 9] to [3, 4, 7, 9]
		int n1 = q + 1 - p;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		
		// populate the left array
		for(int i = 0; i < n1; i++) {
			left[i] = arr[i + p];
		}
		
		// populate the right array
		for(int j = 0; j < n2; j++) {
			right[j] = arr[j + q + 1];
		}
		
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 7, 9, 3};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
