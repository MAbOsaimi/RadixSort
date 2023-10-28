// public class HeapSort {

//     public static void heapSort(String[] arr, int place) {
//         int n = arr.length;
    
//         for (int i = n / 2 - 1; i >= 0; i--)
//             heapify(arr, n, i, place);
    
//         for (int i = n - 1; i >= 0; i--) {
//             String temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;
    
//             heapify(arr, i, 0, place);
//         }
//     }
    
  
//     public static void heapSort(int[] arr, int exp) {
//         int heapSize = arr.length;
//         for (int i = heapSize / 2 - 1; i >= 0; i--) {
//             heapify(arr, i, heapSize, exp);
//         }
//         for (int i = heapSize - 1; i > 0; i--) {
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;
//             heapify(arr, 0, i, exp);
//         }
//     }


//     public static void heapify(String[] arr, int n, int i, int place) {
//         int largest = i;
//         int left = 2 * i + 1;
//         int right = 2 * i + 2;

//         if (left < n && charAtExp(arr[left], place) > charAtExp(arr[largest], place))
//             largest = left;

//         if (right < n && charAtExp(arr[right], place) > charAtExp(arr[largest], place))
//             largest = right;

//         if (largest != i) {
//             String swap = arr[i];
//             arr[i] = arr[largest];
//             arr[largest] = swap;

//             heapify(arr, n, largest, place);
//         }
//     }
//     private static int charAtExp(String str, int exp) {
//         str = str.toLowerCase();
//         if (exp < str.length()) {
//             return str.charAt(str.length() - 1 - exp);
//         } else {
//             return str.charAt(0);
//         }
//     }

    // private static void heapify(int[] arr, int i, int heapSize, int exp) {
    //     int leftChild = 2 * i + 1;
    //     int rightChild = 2 * i + 2;
    //     int largest = i;

    //     if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
    //         largest = leftChild;
    //     }
    //     if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
    //         largest = rightChild;
    //     }
    //     if (largest != i) {
    //         int temp = arr[i];
    //         arr[i] = arr[largest];
    //         arr[largest] = temp;
    //         heapify(arr, largest, heapSize, exp);
    //     }
    // }

  
// }

public class HeapSort {

    public static void heapSort(String[] arr, int place) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, place);

        for (int i = n - 1; i >= 0; i--) {
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, place);
        }
    }

    public static void heapSort(int[] arr, int exp) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, exp);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0, exp);
        }
    }
    // public static void heapSort(int[] arr, int exp) {
    //     int n = arr.length;
    //     for (int i = n / 2 - 1; i >= 0; i--) {
    //         heapify(arr, n, i, exp);
    //     }
    //     for (int i = n - 1; i >= 0; i--) {
    //         int temp = arr[0];
    //         arr[0] = arr[i];
    //         arr[i] = temp;
    //         heapify(arr, i, 0, exp);
    //     }
    // }

    private static void heapify(int[] arr, int n, int i, int exp) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
    
        if (leftChild < n && ((arr[leftChild]/exp)%10) > ((arr[largest]/exp)%10)) {
            largest = leftChild;
        }
        if (rightChild < n && ((arr[rightChild]/exp)%10) > ((arr[largest]/exp)%10)) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest, exp);
        }
    }
   
    
    
    private static void heapify(String[] arr, int n, int i, int place) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && getCharAtPlace(arr[leftChild], place) > getCharAtPlace(arr[largest], place))
            largest = leftChild;

        if (rightChild < n && getCharAtPlace(arr[rightChild], place) > getCharAtPlace(arr[largest], place))
            largest = rightChild;

        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, place);
        }
    }

    private static char getCharAtPlace(String str, int place) {
        str = str.toLowerCase();
        if (place < str.length()) {
            return str.charAt(place);
        } else {
            return str.charAt(0);
        }
    }

    // private static void heapify(int[] arr, int n, int i, int exp) {
    //     int largest = i;
    //     int leftChild = 2 * i + 1;
    //     int rightChild = 2 * i + 2;

    //     if (leftChild < n && getDigitAtExp(arr[leftChild], exp) > getDigitAtExp(arr[largest], exp)) {
    //         largest = leftChild;
    //     }
    //     if (rightChild < n && getDigitAtExp(arr[rightChild], exp) > getDigitAtExp(arr[largest], exp)) {
    //         largest = rightChild;
    //     }
    //     if (largest != i) {
    //         int temp = arr[i];
    //         arr[i] = arr[largest];
    //         arr[largest] = temp;
    //         heapify(arr, n, largest, exp);
    //     }
    // }

    // private static int getDigitAtExp(int num, int exp) {
    //     return (num / exp) % 10;
    // }
}

