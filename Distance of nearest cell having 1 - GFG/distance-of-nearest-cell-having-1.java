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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
       
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new int[]{i,j,});
                    grid[i][j]=0;

                }
                else
                {
                    grid[i][j]=-1;
                }
            }
        }
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        while(!q.isEmpty())
        {
           int s=q.size();
           while(s-->0)
           {
               int[] curr=q.poll();
               
               for(int i=0;i<4;i++)
               {
                   int x=curr[0]+dx[i];
                   int y=curr[1]+dy[i];
                   if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==-1)
                   {
                       
                       grid[x][y]=grid[curr[0]][curr[1]]+1;
                       q.add(new int[]{x,y});
                       
                   }
               }
           }
        }
        return grid;
        
    }
}