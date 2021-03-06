/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
public class SurroundedRegions {

    /**
     *
     * @param board
     */
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<n;i++){
            //最上边的一行
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
            //最下边的一列
            if(board[m-1][i]=='O'){
                dfs(m-1,i,board);
            }
        }
        for(int i=1;i<m-1;i++){
            //最左边的一列
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            //最右边的一列
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     *
     * @param i
     * @param j
     * @param board
     */
    private void dfs(int i, int j, char[][] board) {
        if(i<0||j<0||i>=board.length||j>=board[0].length|| board[i][j] != 'O'){
            return;
        }
        board[i][j]='A';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}
