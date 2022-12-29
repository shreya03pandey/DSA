//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class DisjointSet
{
    int size[],parent[];
    DisjointSet(int n)
    {
        size=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
        parent[i]=i;
    }
    int findPar(int x)
    {
        if(parent[x]==x)
        return x;
        else
        return parent[x]=findPar(parent[x]);
    }
    void unionBySize(int ux,int uy)
    {
        int u=findPar(ux);
        int v=findPar(uy);
        if(u==v)
        return;
        if(size[u]<=size[v])
        {
            parent[u]=v;
            size[v]+=size[u];
        }
        else
        {
            parent[v]=u;
            size[u]+=size[v];
        }
    }
}
class Solution {
    
    public List<Integer> numOfIslands(int n, int m, int[][] op) {
        //Your code here
        DisjointSet ds=new DisjointSet(n*m);
        List<Integer>res=new ArrayList<>();
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<op.length;i++)
        {
            int row=op[i][0];
            int col=op[i][1];
            if(vis[row][col]==1)
            {
                res.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;
            int dx[]={-1,0,0,1};
            int dy[]={0,-1,1,0};
            for(int j=0;j<4;j++)
            {
            int newrow=row+dx[j];
            int newcol=col+dy[j];
            if(newrow>=0&&newrow<n&&newcol>=0&&newcol<m)
            {
                if(vis[newrow][newcol]==1)
                {
                    int node=row*m+col;
                    int newNode=newrow*m+newcol;
                    if(ds.findPar(node)!=ds.findPar(newNode))
                    {
                        cnt--;
                        ds.unionBySize(node,newNode);
                        
                    }
                }
            }
            }
            res.add(cnt);
        }
        return res;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends