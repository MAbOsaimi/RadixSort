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

    private static void heapify(int[] arr, int n, int i, int exp) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && ((arr[leftChild] / exp) % 10) > ((arr[largest] / exp) % 10)) {
            largest = leftChild;
        }
        if (rightChild < n && ((arr[rightChild] / exp) % 10) > ((arr[largest] / exp) % 10)) {
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
}
