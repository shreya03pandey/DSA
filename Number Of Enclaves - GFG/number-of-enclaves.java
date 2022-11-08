//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
//0 0 1 1
//0 1 1 0
//0 1 1 0
//0 0 0 1
//0 1 1 0-->checkout this example Ans:0

class Solution {

    int numberOfEnclaves(int[][] grid) {
        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
          int vis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0||j==0||i==n-1||j==m-1)&&grid[i][j]==1)
                {
                q.add(new int[]{i,j});
                vis[i][j]=1;
                }
            }
        }
       int dx[]={-1,0,0,1};
       int dy[]={0,-1,1,0};
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            for(int i=0;i<4;i++)
            {
                int x=curr[0]+dx[i];
                int y=curr[1]+dy[i];
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1&&vis[x][y]==0)
                {
                    q.add(new int[]{x,y});
                    vis[x][y]=1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1&&vis[i][j]==0)
                {
                cnt++;
                }
            }
        }
        return cnt;
    }
}