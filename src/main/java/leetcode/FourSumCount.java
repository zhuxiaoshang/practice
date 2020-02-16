package leetcode;

import java.util.*;

public class FourSumCount {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(fourSumCount(A,B,C,D));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = A.length;
        int count =0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0)+1);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(null==map.get(-1*(C[i]+D[j]))){
                    continue;
                }
                count+=map.get(-1*(C[i]+D[j]));
            }
        }
        return count;
    }
}
