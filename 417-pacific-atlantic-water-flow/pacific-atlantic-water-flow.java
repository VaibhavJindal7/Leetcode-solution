class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] atl = new int[m][n];
        int[][] pac = new int[m][n];
    
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
             dfs(i, 0, heights, pac);
             dfs(i, n - 1, heights, atl);
        }

        for (int j = 0; j < n; j++) {
             dfs(0, j, heights, pac);
             dfs(m - 1, j, heights, atl);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atl[i][j]==1 && pac[i][j]==1){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    ans.add(ls);
                }
            }
        }
        return ans;
    }
    void dfs(int row,int col,int[][] heights,int[][] pac){
        if(pac[row][col]==1) return;
         
        pac[row][col]=1;
        int[] dir1 ={0,1,0,-1};
        int[] dir2 ={1,0,-1,0};
        for(int i=0;i<4;i++){
            int nrow = row + dir1[i];
            int ncol = col+dir2[i];
            if(nrow>=0&&nrow<heights.length&&ncol>=0&&ncol<heights[0].length){
                if(heights[nrow][ncol]>=heights[row][col]){
                    if(pac[nrow][ncol]==0)
                    dfs(nrow,ncol,heights,pac);
                }   
            }
        }
    }
}