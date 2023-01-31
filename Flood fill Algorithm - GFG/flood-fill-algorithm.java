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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int iniColor,int newColor)
    {
        image[sr][sc]=newColor;
        int[] dy={0,-1,1,0};
        int[] dx={-1,0,0,1};
        for(int i=0;i<4;i++)
        {
            int x=sr+dx[i];
            int y=sc+dy[i];
            if(x>=0&&y>=0&&x<image.length&&y<image[0].length&&image[x][y]==iniColor&&image[x][y]!=newColor)
            dfs(image,x,y,image[x][y],newColor);
        }
    }
}