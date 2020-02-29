package leetcode;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[][] matrix = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;
//        System.out.println(kthSmallest(matrix, 8));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                queue.add(matrix[i][j]);
                if (queue.size() > matrix.length*matrix.length-k+1) {
                    queue.poll();
                }
            }

        }
        System.out.println(queue.peek());
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int H = n * n - k + 1;//第K小，反过来就是第n^2-k+1大的元素
        int[] minHeap = new int[H];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t == H) {
                    break;
                }
                minHeap[t++] = matrix[i][j];
            }
        }
        //用前H个元素构建最小堆，剩下的元素依次和堆顶元素比较，如果比堆顶元素大则替换之
        for (int i = H / 2; i >= 0; i--) {
            buildMinHeap(minHeap, i, n, H);
        }
        for (int i = H + 1; i <= n * n; i++) {
            if (matrix[getRow(i, n)][getCol(i, n)] > minHeap[0]) {
                minHeap[0] = matrix[getRow(i, n)][getCol(i, n)];
                buildMinHeap(minHeap, 0, n, H);
            }
        }
        return minHeap[0];
    }

    public static void buildMinHeap(int[] minHeap, int root, int n, int H) {
        int left = 2 * root;
        int right = 2 * root + 1;

        int tmp = root;
        if (left < H && minHeap[root] > minHeap[left]) {
            tmp = left;
        }

        if (right < H && minHeap[left] > minHeap[right]) {
            tmp = right;
        }
        if (tmp != root) {
            int m = minHeap[root];
            minHeap[root] = minHeap[tmp];
            minHeap[tmp] = m;
            buildMinHeap(minHeap, tmp, n, H);
        }

    }

    public static int getRow(int index, int n) {
        return index % n == 0 ? index / n - 1 : index / n;
    }

    public static int getCol(int index, int n) {
        return (index % n == 0 ? n : index % n) - 1;
    }


}
