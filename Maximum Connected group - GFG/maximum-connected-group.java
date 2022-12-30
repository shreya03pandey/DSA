//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet
{
    int size[],parent[];
    DisjointSet(int n)
    {
        size=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
        parent[i]=i;
        Arrays.fill(size,1);
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
        if(size[u]<size[v])
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
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        //Step 1-Establishing Connections
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                continue;
                int dy[]={0,-1,1,0};
                int dx[]={-1,0,0,1};
                for(int k=0;k<4;k++)
                {
                    int newr=i+dx[k];
                    int newc=j+dy[k];
                    if(newr>=0&&newr<n&&newc>=0&&newc<n&&grid[newr][newc]==1)
                    {
                        int node=i*n+j;
                        int newn=newr*n+newc;
                        ds.unionBySize(node,newn);
                    }
                }
                
            }
        }
        int res=0;
        // Step 2->Find out the 0's to track max
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                continue;
                int dy[]={0,-1,1,0};
                int dx[]={-1,0,0,1};
                HashSet<Integer>h=new HashSet<>();
                for(int k=0;k<4;k++)
                {
                    int newr=i+dx[k];
                    int newc=j+dy[k]; 
                    if(newr>=0&&newr<n&&newc>=0&&newc<n&&grid[newr][newc]==1)
                    h.add(ds.findPar(newr*n+newc));
                }
                int size=0;
                for(int par:h)
                {
                //  System.out.println(par);
                size+=ds.size[par];
                }
                res=Math.max(res,size+1);
            }
        }
        // what if the entire matrix contains 1
        for(int i=0;i<n*n;i++)
        res=Math.max(res,ds.size[ds.findPar(i)]);
        return res;
        
    }
    
}