package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] src = {12, 44, 14, 54, 8, 102, 63, 11, 35, 27, 111, 55};
        //正序
//        for (int i = src.length; i >0; i--) {
//            for (int j = 0; j < i - 1; j++) {
//                if (src[j + 1] <src[j]) {
//                    int tmp;
//                    tmp = src[j];
//                    src[j] = src[j+1];
//                    src[j+1] = tmp;
//                }
//            }
//        }
//倒序
        for (int i = 0; i < src.length; i++) {
            for (int j = src.length - 1; j > i; j--) {
                if (src[j] > src[j - 1]) {
                    int tmp;
                    tmp = src[j];
                    src[j] = src[j - 1];
                    src[j - 1] = tmp;
                }
            }
        }
        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }
}
