//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
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
        if(u==v) return;
        if(size[u]<size[v])
        {
           par[u]=v;
           size[v]+=size[u];
        }
        else
        {
            par[v]=u;
            size[u]+=size[u];
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds=new DisjointSet(V);
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                if(adj.get(i).get(j)==1)
                ds.unionBySize(i,j);
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++)
        {
            if(ds.par[i]==i)
            cnt++;
        }
        return cnt;
    }
};