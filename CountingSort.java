
public class CountingSort {

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void countingSort(String[] arr, int place) {
        int n = arr.length;
        String[] output = new String[n];
        int[] count = new int[256];

        for (String s : arr) {
            char ch = place < s.length() ? Character.toLowerCase(s.charAt(place)) : 0;
            count[ch]++;
        }

        for (int i = 1; i <= 255; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = place < arr[i].length() ? Character.toLowerCase(arr[i].charAt(place)) : 0;
            output[--count[ch]] = arr[i];
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
