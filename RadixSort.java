import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    public static void generateIds(int[] arr, int size) { // Generates "size" amount of 9-digit numbers that start with
                                                          // "44".
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = 440000000 + random.nextInt(10000000);
        }
    }

    public static void generateStrings(String[] arr, int size) { // Generates "size" amount of strings with 5-10
                                                                 // characters
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < size; i++) {
            int length = random.nextInt(6) + 5;
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
                sb.append(randomChar);
            }
            arr[i] = sb.toString();
        }

    }

    public static int findMaxLen(String[] arr) {
        int maxLen = arr[0].length();
        for (int i = 1; i < arr.length; i++)
            if (arr[i].length() > maxLen)
                maxLen = arr[i].length();
        return maxLen;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void printSortedResults(String[] arrStr, int[] arrInt) { 
        System.out.println();
        String[] originalStr = Arrays.copyOf(arrStr, arrStr.length);
        System.out.println("Strings demo:");
        System.out.println("Original array: " + Arrays.toString(originalStr));
    
        String[] arrCopy = Arrays.copyOf(arrStr, arrStr.length);
        mergeRadixSort(arrCopy);
        System.out.println("After mergeRadixSort: " + Arrays.toString(arrCopy));
    
        arrCopy = Arrays.copyOf(arrStr, arrStr.length);
        insertionRadixSort(arrCopy);
        System.out.println("After insertionRadixSort: " + Arrays.toString(arrCopy));
    
        arrCopy = Arrays.copyOf(arrStr, arrStr.length);
        quickRadixSort(arrCopy);
        System.out.println("After quickRadixSort [Unstable!]: " + Arrays.toString(arrCopy));
    
        arrCopy = Arrays.copyOf(arrStr, arrStr.length);
        heapRadixSort(arrCopy);
        System.out.println("After heapRadixSort [Unstable!]: " + Arrays.toString(arrCopy));
    
        arrCopy = Arrays.copyOf(arrStr, arrStr.length);
        countingRadixSort(arrCopy);
        System.out.println("After countingRadixSort: " + Arrays.toString(arrCopy));
        
        int[] originalInt = Arrays.copyOf(arrInt, arrInt.length);
        System.out.println("Integer demo:");
        System.out.println("Original array: " + Arrays.toString(originalInt));
    
        int[] arrCopyInt = Arrays.copyOf(arrInt, arrInt.length);
        mergeRadixSort(arrCopyInt);
        System.out.println("After mergeRadixSort: " + Arrays.toString(arrCopyInt));
    
        arrCopyInt = Arrays.copyOf(arrInt, arrInt.length);
        insertionRadixSort(arrCopyInt);
        System.out.println("After insertionRadixSort: " + Arrays.toString(arrCopyInt));
    
        arrCopyInt = Arrays.copyOf(arrInt, arrInt.length);
        quickRadixSort(arrCopyInt);
        System.out.println("After quickRadixSort [Unstable!]: " + Arrays.toString(arrCopyInt));
    
        arrCopyInt = Arrays.copyOf(arrInt, arrInt.length);
        heapRadixSort(arrCopyInt);
        System.out.println("After heapRadixSort [Unstable!]: " + Arrays.toString(arrCopyInt));
    
        arrCopyInt = Arrays.copyOf(arrInt, arrInt.length);
        countingRadixSort(arrCopyInt);
        System.out.println("After countingRadixSort: " + Arrays.toString(arrCopyInt));
    }
    

    // Merge sort:

    public static void mergeRadixSort(String[] arr) {

        int maxLen = findMaxLen(arr);
        for (int place = maxLen - 1; place >= 0; place--) {
            MergeSort.mergeSort(arr, 0, arr.length - 1, place);
        }
    }

    public static void mergeRadixSort(int[] arr) {
        int max = findMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            MergeSort.mergeSort(arr, 0, arr.length - 1, exp);
        }

    }

    // Insertion sort:

    public static void insertionRadixSort(String[] arr) {
        int maxLen = findMaxLen(arr);
        for (int place = maxLen - 1; place >= 0; place--) {
            InsertionSort.insertionSort(arr, place);
        }
    }

    public static void insertionRadixSort(int[] arr) {
        int max = findMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            InsertionSort.insertionSort(arr, exp);
        }
    }

    // Quick sort: ! [Quick sort is an unstable sorting algorithm; It may not
    // correctly sort the array when used by radix sort]

    public static void quickRadixSort(String[] arr) {
        int maxLen = findMaxLen(arr);
        for (int place = maxLen - 1; place >= 0; place--) {
            QuickSort.quickSort(arr, 0, arr.length - 1, place);
        }
    }

    public static void quickRadixSort(int[] arr) {
        int max = findMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            QuickSort.quickSort(arr, 0, arr.length - 1, exp);
        }
    }

    // Heap sort: ! [Heap sort is an unstable sorting algorithm; It may not
    // correctly sort the array when used by radix sort]

    public static void heapRadixSort(String[] arr) {
        int maxLen = findMaxLen(arr);
        for (int place = 0; place < maxLen; place++) {
            HeapSort.heapSort(arr, place);
        }
    }

    public static void heapRadixSort(int[] arr) {
        int max = findMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            HeapSort.heapSort(arr, exp);
        }
    }

    // Counting sort:

    public static void countingRadixSort(String[] arr) {
        int maxLen = findMaxLen(arr);
        for (int place = maxLen - 1; place >= 0; place--) {
            CountingSort.countingSort(arr, place);
        }
    }

    public static void countingRadixSort(int[] arr) {
        int max = findMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            CountingSort.countingSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] intArrDemo = new int[1000];
        String[] strArrDemo = new String[1000];
        generateIds(intArrDemo, 1000);
        generateStrings(strArrDemo, 1000);
        printSortedResults(strArrDemo, intArrDemo);
    }
}
