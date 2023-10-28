
// public class CountingSort {
    
//    public static void countingSort (int [] A, int exp) {
// int n = A.length;
// int k = 10;
// int[] B = new int[n];
// int[] C = new int[k + 1];
// for (int j= 0; j<n; j++){
// C[(A[j]/exp) % 10]++;
// }
// for (int i = 1; i < k; i++) {
// C[i] += C[i - 1];
// }
// for (int j=n - 1;j>= 0;j--){
// B[C[(A[j]/exp) % 10] - 1] = A[j];
// C[(A[j]/exp) % 10]--;
// }

// for (int i = 0; i < n; i++) {
// A[i] = B[i];
// }
// }





// public static void countingSort(String[] arr, int exp) {
//     int n = arr.length;
//     String[] output = new String[n];
//     int[] count = new int[256];

//     for (int i = 0; i < n; i++) {
//         char ch = exp < arr[i].length() ? Character.toLowerCase(arr[i].charAt(exp)) : 0;
//         count[ch]++;
//     }

//     for (int i = 1; i <= 255; i++) {
//         count[i] += count[i - 1];
//     }

//     for (int i = n - 1; i >= 0; i--) {
//         char ch = exp < arr[i].length() ? Character.toLowerCase(arr[i].charAt(exp)) : 0;
//         output[count[ch] - 1] = arr[i];
//         count[ch]--;
//     }

//     for (int i = 0; i < n; i++) {
//         arr[i] = output[i];
//     }
// }


// private static int charAtExp(String str, int exp) {
//     str = str.toLowerCase();
//     if (exp < str.length()) {
//         return str.charAt(str.length() - 1 - exp);
//     } else {
//         return str.charAt(0);
//     }
// }
// }


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

    public static void countingSort(String[] arr, int exp) {
        int n = arr.length;
        String[] output = new String[n];
        int[] count = new int[256];

        for (String s : arr) {
            char ch = exp < s.length() ? Character.toLowerCase(s.charAt(exp)) : 0;
            count[ch]++;
        }

        for (int i = 1; i <= 255; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = exp < arr[i].length() ? Character.toLowerCase(arr[i].charAt(exp)) : 0;
            output[--count[ch]] = arr[i];
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
