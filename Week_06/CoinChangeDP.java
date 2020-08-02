import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChangeDP {

    /**
     * BFS广度优先遍历
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        //队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);

        //记录访问节点
        HashSet<Integer> visited = new HashSet<Integer>();

        int coinNum = 0;//遍历的层数 即为最小需要的硬币数

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int current = queue.peek();
                // Base case
                if (current == 0) {
                    return coinNum;
                }
                queue.remove();
                if (visited.contains(current) || current < 0) {
                    continue;
                }
                visited.add(current);

                for (int c = 0; c < n; c++) {
                    queue.add(current - coins[c]);
                }
            }
            coinNum++;
        }
        return -1;
    }

    /**
     * DP动态规划
     *
     * DP Array:f(n)=min{f(n-k),for k in [1,2,5]}+1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeI(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<amount;i++){
            for(int j=0;i<coins.length;i++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
