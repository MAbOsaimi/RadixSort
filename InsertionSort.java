public class InsertionSort {

    public static void insertionSort(String[] arr, int exp) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            char k = ' ';
            if (exp < arr[i].length()) {
                k = key.toLowerCase().charAt(exp);
            }
            int j = i - 1;
            while (j >= 0 && arr[j].length() > exp && k < arr[j].toLowerCase().charAt(exp)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(int[] arr, int exp) {
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && (key / exp) % 10 < (arr[j] / exp) % 10) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }
}
