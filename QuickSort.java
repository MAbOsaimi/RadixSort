public class QuickSort {

    public static void quickSort(String[] arr, int low, int high, int place) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, place);
            quickSort(arr, low, partitionIndex - 1, place);
            quickSort(arr, partitionIndex + 1, high, place);
        }
    }

    public static void quickSort(int[] arr, int low, int high, int exp) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, exp);
            quickSort(arr, low, partitionIndex - 1, exp);
            quickSort(arr, partitionIndex + 1, high, exp);
        }
    }

    private static int partition(String[] arr, int low, int high, int exp) {
        String pivot = arr[high];
        char pivotChar = ' ', currChar = ' ';

        if (exp < pivot.length()) {
            pivotChar = pivot.toLowerCase().charAt(exp);
        }
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (exp < arr[j].length()) {
                currChar = arr[j].toLowerCase().charAt(exp);
            }
            if (currChar < pivotChar) {
                i += 1;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static int partition(int[] arr, int low, int high, int exp) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((arr[j] / exp) % 10 <= (pivot / exp) % 10) {
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
