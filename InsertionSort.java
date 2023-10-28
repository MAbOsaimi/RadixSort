public class InsertionSort {

    public static void insertionSort(String[] arr, int place) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            char k = ' ';
            if (place < arr[i].length()) {
                k = key.toLowerCase().charAt(place);
            }
            int j = i - 1;
            while (j >= 0 && arr[j].length() > place && k < arr[j].toLowerCase().charAt(place)) {
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