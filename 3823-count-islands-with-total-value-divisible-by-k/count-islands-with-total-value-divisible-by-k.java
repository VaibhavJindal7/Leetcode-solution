class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                   long sum = dfs(i,j,grid);
                   if(sum%k==0) cnt++;
                }
            }
        }
        return cnt;
    }
    long dfs(int i,int j,int[][] grid){
        if(grid[i][j]==0) return 0;
        long sum=0;
        Stack<int[]> st = new Stack<>();
        sum+=grid[i][j];
        grid[i][j]=0;
        st.push(new int[]{i,j});
        int[][] dr = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!st.isEmpty()){
            int[] cur = st.pop();
            for(int k=0;k<4;k++){
                int ni = cur[0]+dr[k][0];
                int nj = cur[1]+dr[k][1];
                if(ni>=0&&ni<grid.length&&nj>=0&&nj<grid[0].length&&grid[ni][nj]!=0){
                    sum+=grid[ni][nj];
                    grid[ni][nj]=0;
                    st.push(new int[]{ni,nj});
                }
            }
        }
        return sum;
    }
}