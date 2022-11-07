//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((i==0||j==0||i==n-1||j==m-1)&&a[i][j]=='O'&&vis[i][j]==0)
                dfs(a,i,j,vis,n,m);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0&&a[i][j]=='O')
                a[i][j]='X';
                
            }
        }
        return a;
    }
    static void dfs(char a[][],int i,int j,int vis[][],int n,int m)
    {
        vis[i][j]=1;
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        for(int idx=0;idx<4;idx++)
        {
            int x=i+dx[idx];
            int y=j+dy[idx];
            if(x>=0&&x<n&&y>=0&&y<m&&a[x][y]=='O'&&vis[x][y]==0)
            dfs(a,x,y,vis,n,m);
        }
    }
}