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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Triplet
{
    int first,second,third;
    Triplet(int f,int s,int t)
    {
        first=f;
        second=s;
        third=t;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] src, int[] dest) {

        // Your code here
      if(src[0]==dest[0]&&src[1]==dest[1])
      return 0;
      int m=grid.length;
      int n=grid[0].length;
      int dis[][]=new int[m][n];
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              dis[i][j]=(int)(1e9);
          }
      }
      Queue<Triplet>q=new LinkedList<>();
      dis[src[0]][src[1]]=0;
      q.add(new Triplet(0,src[0],src[1]));
      while(!q.isEmpty())
      {
         Triplet tri=q.poll();
         int d=tri.first;
         int xc=tri.second;
         int yc=tri.third;
         int dx[]={-1,0,0,1};
         int dy[]={0,-1,1,0};
         for(int i=0;i<4;i++)
         {
             int x=xc+dx[i];
             int y=yc+dy[i];
             if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1&&dis[x][y]>d+1)
             {
                 dis[x][y]=d+1;
                 if(x==dest[0]&&y==dest[1])
                 return dis[x][y];
                 q.add(new Triplet(dis[x][y],x,y));
             }
         }
      }
      return -1;
    }
}
