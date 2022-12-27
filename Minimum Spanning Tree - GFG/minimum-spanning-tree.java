//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Triplet implements Comparable<Triplet>
{
    int src,dest,wt;
    Triplet(int src,int dest,int wt)
    {
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
    public int compareTo(Triplet edge)
    {
        return this.wt-edge.wt;
    }
}
class DisjointSet
{
    int size[];
    int parent[];
    DisjointSet(int n)
    {
        size=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
        parent[i]=i;
    }
	int find(int X)//find Parent
    {
          //add code here.
          if(parent[X]==X)
          return X;
          return parent[X]=find(parent[X]);
          
	}
	void unionBySize(int X,int Z)
        {
         //add code here.
         int ulx=find(X);  //ultimate parent of x
         int ulz=find(Z);   //ultimate parent of z
         if(ulx==ulz)
         return;     //they already belong to the same component
         if(size[ulx]<=size[ulz])
         {
             parent[ulx]=ulz;
             size[ulz]+=size[ulx];//larger becomes the parent
         }
         else
         if(size[ulz]<size[ulx])
         {
         parent[ulz]=ulx;
         size[ulx]+=size[ulz];
         }

	}
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        List<Triplet> al=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                int node=i;
                int adjNode=adj.get(i).get(j).get(0);
                int wt=adj.get(i).get(j).get(1);
                al.add(new Triplet(node,adjNode,wt));
            }
        }
        Collections.sort(al);
        int res=0;
        DisjointSet ds=new DisjointSet(V);
        for(int i=0;i<al.size();i++)
        {
            Triplet t=al.get(i);
            int u=t.src;
            int v=t.dest;
            int w=t.wt;
            if(ds.find(u)!=ds.find(v))
            {
                res+=w;
                ds.unionBySize(u,v);
            }
        }
        return res;
    }
}
