public class MergeSort {

    public static void mergeSort(String[] arr, int low, int high, int place) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, place);
            mergeSort(arr, mid + 1, high, place);
            merge(arr, low, mid, high, place);
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int exp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, exp);
            mergeSort(arr, mid + 1, high, exp);
            merge(arr, low, mid, high, exp);
        }
    }

    private static void merge(String[] arr, int low, int mid, int high, int place) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        String[] L = new String[n1];
        String[] R = new String[n2];

        System.arraycopy(arr, low, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0;
        int j = 0;

        for (int k = low; k <= high; k++) {
            char m = i < n1 && place < L[i].length() ? Character.toLowerCase(L[i].charAt(place)) : 0;
            char n = j < n2 && place < R[j].length() ? Character.toLowerCase(R[j].charAt(place)) : 0;

            if (i < n1 && (j >= n2 || m <= n)) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int exp) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, low, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;

        for (int k = low; k <= high; k++) {
            if (i < n1 && (j >= n2 || ((L[i] / exp) % 10 <= (R[j] / exp) % 10))) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
        }
    }
}
