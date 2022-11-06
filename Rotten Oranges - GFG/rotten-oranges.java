//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                q.add(new int[]{i,j});
            }
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                int[] res=q.poll();
                for(int i=0;i<4;i++)
                {
                int x=res[0]+dx[i];
                int y=res[1]+dy[i];
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1)
                {
                    grid[x][y]=2;
                    q.add(new int[]{x,y});
                }
                }
            }
            if(q.size()>0) cnt++;
        }
           for(int i=0;i<n;i++)
             {
             for(int j=0;j<m;j++)
               {
                if(grid[i][j]==1)
                return -1;
               }
             }
             return cnt;
    }
}