/**
 * 不同路径：存在障碍物
 */
public class UniquePathsWithObstacles {

    /**
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                paths[i][0] = 0;
                break;//遇到障碍物就结束了
            } else {
                paths[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1) {
                paths[0][j] = 0;
                break;//遇到障碍物就结束了
            } else {
                paths[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
