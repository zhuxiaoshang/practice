package sort;


public class SelectSort {
    public static void main(String[] args) {
        int[] src = {12, 44, 14, 54, 8, 102, 63, 11, 35, 27, 111, 55};
        for (int i = 0; i < src.length; i++) {
            int min = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[min] > src[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(src, i, min);
            }

        }

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
