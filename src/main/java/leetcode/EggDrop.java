package leetcode;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * <p>
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * <p>
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * <p>
 * 你的目标是确切地知道 F 的值是多少。
 * <p>
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * <p>
 * 示例1：输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * <p>
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 */
public class EggDrop {
    public static void main(String[] args) {
        System.out.println(superEggDrop(3,14));
    }

    /**
     * K=1 or N<=2 : f(K,N) =N
     * else: f(K,N) = max(f(K-1,X-1), f(k,N-X)) + 1
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop(int K, int N) {
        if (K == 1 || N <= 2) {
            return N;
        }
        int[][] dp = new int[K][N + 1];
        for (int i = 0; i < K; i++) {
            //楼层小于2时不管有多少个蛋，次数都和楼层一样
            dp[i][0] = 0;
            dp[i][1] = 1;
            dp[i][2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            //当只有一个蛋时，不管多少层楼，次数也和楼层一样
            dp[0][i] = i;
        }
        //蛋从1开始，楼层从3开始
        for (int k = 1; k < K; k++) {
            int x = 1;
            for (int n = 3; n <= N; n++) {
                //dp[k - 1][x - 1]是单调递增的，dp[k][n - x]单调递减的，寻找他们的交叉点
                if (dp[k - 1][x - 1] < dp[k][n - x]) {
                    x++;
                }
                dp[k][n] = Math.max(dp[k - 1][x - 1], dp[k][n - x])+1;

            }

        }
        return dp[K -1][N];//这里K-1是因为，索引0的位置表示了1个鸡蛋，以此类推，楼层是从0层开始的
    }
}
