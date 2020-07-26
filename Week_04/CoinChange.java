import java.util.Arrays;

/**
 * 零钱交换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChange {

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] ans = new int[1];
        ans[0] = 1 << 31 - 1;
        dfs(amount, coins, coins.length - 1, 0, ans);
        return ans[0] == 1 << 31 - 1 ? -1 : ans[0];
    }

    /**
     * @param amount
     * @param coins
     * @param c_index
     * @param times
     * @param ans
     */
    private void dfs(int amount, int[] coins, int c_index, int times, int[] ans) {
        if(amount==0){
           ans[0]=Math.min(ans[0],times);
        }

        if(c_index<0){
            return;
        }

        int k=amount/coins[c_index];
        for(int i=k;i>=0&&k+times<ans[0];i--){
          dfs(amount-coins[c_index]*i,coins,c_index-1,times+i,ans);
        }
    }
}
