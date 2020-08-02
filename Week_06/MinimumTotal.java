import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class MinimumTotal {

    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] ans=new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                ans[j]=Math.min(ans[j],ans[j+1])+triangle.get(i).get(j);
            }
        }
        return ans[0];
    }

    Integer[][] memo;
    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotalI(List<List<Integer>> triangle){
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    /**
     *
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if(i==triangle.size()){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        return memo[i][j]=Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1))+triangle.get(i).get(j);
    }

    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotalII(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
