package bfsdfs;

/**
 * 岛屿数量
 */
public class NumIslands {

    /**
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        if(grid.length<=0){
            return 0;
        }
        int m=grid[0].length;
        for(int i=0;i<n;i++){
           for(int j=0;i<m;j++){
               if(grid[i][j]=='1'){
                  DFSMarking(grid,i,j,n,m);
                  count++;
               }
           }
        }
        return count;
    }

    /**
     *
     * @param grid
     * @param i
     * @param j
     * @param n
     * @param m
     */
    private void DFSMarking(char[][] grid, int i, int j, int n, int m) {
        if(i<0||j<0||j>=m||j>=n||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='0';
        DFSMarking(grid,i+1,j,n,m);
        DFSMarking(grid,i-1,j,n,m);
        DFSMarking(grid,i,j+1,n,m);
        DFSMarking(grid,i,j-1,n,m);
    }
}
