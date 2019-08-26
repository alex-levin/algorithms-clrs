package common;

public class Util {

    /**
     * Display array elements
     */
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    
    public static void printArray(int[] inputArray) {
        for (int element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}