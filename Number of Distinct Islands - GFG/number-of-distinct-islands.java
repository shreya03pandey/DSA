//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
      int vis[][]=new int[n][m];
      HashSet<ArrayList<String>>h=new HashSet<>();
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<m;j++)
          {
              if(vis[i][j]==0&&grid[i][j]==1)
              {
                  ArrayList<String>al=new ArrayList<>();//for storing the values which form an island
                  dfs(grid,i,j,vis,al,i,j);
                  h.add(al);//add the al to set for unique island(identical elimination)
              }
          }
      }
      return h.size();
    }
    void dfs(int[][] grid,int i,int j,int[][] vis,ArrayList<String>al,int basei,int basej)
    {
       int n=grid.length;
       int m=grid[0].length;
       vis[i][j]=1;
       al.add(toString(i-basei,j-basej));
       int dx[]={-1,0,0,1};
       int dy[]={0,-1,1,0};
       for(int idx=0;idx<4;idx++)
       {
           int x=i+dx[idx];
           int y=j+dy[idx];
           if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1&&vis[x][y]==0)
           dfs(grid,x,y,vis,al,basei,basej);
       }
    }
    String toString(int x,int y)
    {
        return String.valueOf(x)+" "+String.valueOf(y);
    }
}
