//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

       int vis[]=new int[V];
       int pathvis[]=new int[V];
       int safe[]=new int[V];
       for(int i=0;i<V;i++)
       {
           if(vis[i]==0)
           dfs(adj,i,vis,pathvis,safe);//we don't need to just check for a cycle but for all 
                              //the paths
       }
       List<Integer>res=new ArrayList<>();
       for(int i=0;i<V;i++)
       if(safe[i]==1)
       res.add(i);
       return res;
    }
    public boolean dfs(List<List<Integer>> adj,int u,int vis[],int pathvis[],int safe[])
    {
      vis[u]=1;
      pathvis[u]=1;
      for(Integer it:adj.get(u))
      {
          if(vis[it]==0)
          {
            if(dfs(adj,it,vis,pathvis,safe))
            return true;
          }
          else
          if(pathvis[it]==1)
          return true;
      }
      pathvis[u]=0;
      safe[u]=1;
      return false;
    }
    
    
}
