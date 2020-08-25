/**
 * 322. Coin Change
 * Medium
 *
 * 4601
 *
 * 142
 *
 * Add to List
 *
 * Share
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChangeDPI {

    /**
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=0;i<dp.length;i++){
            //内置for在求所有子问题+ 1的最小值
            for(int coin:coins){
                //子问题无解，跳过
                if(i-coin<0){
                    continue;
                }
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
