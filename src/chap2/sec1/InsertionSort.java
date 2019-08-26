package chap2.sec1;

import common.Util;

public class InsertionSort {
	
    public static int[] sort(int[] arr) {
        // At the beginning of each iteration of the for loop, which is indexed by j,
    	// the subarray consisting
        // of elements arr[0..j-1] constitutes the currently sorted hand, and the remaining
        // subarray arr[j+1..n] corresponds to the pile of cards still on the table    	
        for(int j = 1; j < arr.length; j++) {
        	int cur = arr[j];
            int i = j;
            // Shift the subarray arr[0..j-1] elements to the right
            while(i > 0 && arr[i - 1] > cur) {
                arr[i] = arr[i - 1];
                i--;
            }
            arr[i] = cur;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] sorted = sort(arr);
        Util.printArray(sorted);
    }
}