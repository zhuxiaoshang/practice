package leetcode;

/**
 * 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {

        int[] coins = {186,419,83,408};
        int amount = 6249;

        System.out.println(coinChange(coins,amount));

    }

    public static int coinChange(int[] coins, int amount) {
       //f(n) = min(f(n),1+f(n-coin)
        int[] dp = new int[amount+1];
        return recursion(coins, amount, dp);
    }

    public static int recursion(int[] coins,int amount,int[] dp)
    {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = recursion(coins, amount - coin, dp);
            if(sub==-1){
                continue;
            }
            min = Math.min(min, recursion(coins, amount - coin, dp)+1);
        }
        return dp[amount]=min==Integer.MAX_VALUE?-1:min;
    }

}
