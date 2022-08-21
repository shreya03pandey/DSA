class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
       int dp[][]=new int[n][m]; 
        for(int x[]:dp)
            Arrays.fill(x,-1);
      return isMin(dp,grid,n-1,m-1);  
    }
    public int isMin(int[][] dp ,int[][] grid,int i,int j)
    {
        if(i==0&&j==0)
            return grid[0][0];
        if(i<0||j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j]!=-1)
            return dp[i][j];
        
         int up=grid[i][j]+isMin(dp,grid,i-1,j);
         int left=grid[i][j]+isMin(dp,grid,i,j-1);
        return dp[i][j]= Math.min(up,left);
    }
}