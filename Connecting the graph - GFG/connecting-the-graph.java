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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet
{
    int par[];
    int size[];
    DisjointSet(int n)
    {
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++)
        par[i]=i;
    }
    int findPar(int x)
    {
        if(par[x]==x)
        return x;
        else
        return par[x]=findPar(par[x]);
    }
    void unionBySize(int ux,int vx)
    {
        int u=findPar(ux);
        int v=findPar(vx);
        if(u==v)
        return;
        if(size[u]<size[v])
        {
            par[u]=v;
            size[v]+=size[u];
        }
        else
        {
            par[v]=u;
            size[u]+=size[v];
        }
    }
}
class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        int m=edge.length;
        DisjointSet ds=new DisjointSet(n);
        int cntExtra=0;
        for(int i=0;i<m;i++)
        {
            int u=edge[i][0];
            int v=edge[i][1];
            if(ds.findPar(u)==ds.findPar(v))
            cntExtra++;
            else
            ds.unionBySize(u,v);
        }
        int cntComp=0;
        for(int i=0;i<n;i++)
        if(ds.par[i]==i)
        cntComp++;
        int ans=cntComp-1;
        if(cntExtra>=ans)
        return ans;
        else
        return -1;
        
    }
}