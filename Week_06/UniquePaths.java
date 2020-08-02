/**
 *不同路径：路径计数
 * 一个人从左上角走到右下角每次只能移动一步，问好久能够到达右下角 m*n
 * 移动：只能往下或者往右
 *
 * 自底向上推理
 */
public class UniquePaths {

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
