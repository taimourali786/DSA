package LeetCode;

import java.lang.reflect.Array;

public class CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0 ; i < amount +1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int coin : coins) {
            for(int j = coin ; j < amount +1; j++) {
                dp[j] =  Math.min(dp[j], dp[j-coin] + 1);
            }
        }
        return dp[amount] <= Integer.MAX_VALUE ? dp[amount] :  -1;
    }
}
