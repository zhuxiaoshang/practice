package sort;
/**
 * @author: zhushang
 * @create: 2021-04-15 19:32
 */
public class HeapSort {
  public static void main(String[] args) {
    int[] a = new int[] {1, 0, 9, 8, 77, 22, 33, 12, 55, 4, 21};
    buildHeap(a, a.length - 1);
    for (int i : a) {
      System.out.println(i);
    }
  }

  public static void MaxHeapify(int[] a, int index, int size) {
    int l = 2 * index + 1; // 左节点
    int r = 2 * index + 2; // 右节点
    int largest = index;
    if (l <= size && a[l] > a[index]) {
      largest = l;
    }
    if (r <= size && a[r] > a[largest]) {
      largest = r;
    }
    if (largest != index) {
      swap(a, largest, index);
      // 这一步的作用就是在上层交换完之后，下面的子二叉树可能又不满足最大堆，对子二叉树继续进行构造，递归调用
      MaxHeapify(a, largest, size);
    }
  }

  public static void buildHeap(int[] a, int size) {
    // 先从最后一个有子节点的父节点开始构造最大堆，往树顶遍历。
    for (int i = size / 2; i >= 0; i--) {
      // 自下而上
      MaxHeapify(a, i, size);
    }
    // 经过上面的建堆后，已经是一个最大堆了，堆顶就是最大值，第二和第三大的肯定是在第二层
    // 第一遍构造完最大堆后，堆顶元素和最后一个元素交换，对前n-1个元素继续构造最大堆
    for (int i = size; i > 0; i--) {
      swap(a, i, 0);
      // 自上而下堆化
      MaxHeapify(a, 0, i - 1);
    }
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
