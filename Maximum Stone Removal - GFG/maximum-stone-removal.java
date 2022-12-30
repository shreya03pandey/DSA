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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
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

    int maxRemove(int[][] stones, int n) {
        // Code here
        int mxrow=0,mxcol=0;
        for(int i=0;i<n;i++)
        {
            mxrow=Math.max(mxrow,stones[i][0]);
            mxcol=Math.max(mxcol,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(mxrow+mxcol+1);//not writing +2 bcoz disjointset considers it equals
        for(int i=0;i<n;i++)
        {
            int first=stones[i][0];
            int sec=stones[i][1]+mxrow+1;
            ds.unionBySize(first,sec);
        }
        int cnt=0;
        for(int i=0;i<=mxrow+mxcol+1;i++)
        {
            if(ds.findPar(i)==i && ds.size[i]>1)
            cnt++;
        }
        return n-cnt;
    }
};
