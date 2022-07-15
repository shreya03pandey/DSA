class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int m=grid.length;
        int n=grid[0].length;
       int arr[]=new int[1];
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[0]=0;
                dfs(i,j,m,n,grid,arr);
              max=Math.max(max,arr[0]);  
            }
        }
        return max;
    }
    public void dfs(int i,int j,int m,int n,int[][] grid,int arr[])
    {
        if(grid[i][j]==0)
            return ;
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        grid[i][j]=0;
        arr[0]++;
        for(int k=0;k<4;k++)
        {
          int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n && grid[x][y]==1)
            {
                
                dfs(x,y,m,n,grid,arr);
            }
        }
       
    }
}