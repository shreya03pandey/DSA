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

      ArrayList<ArrayList<Integer>>al=new ArrayList<>();
      for(int i=0;i<V;i++)
      al.add(new ArrayList<>());
       int indegree[]=new int[V];
      for(int i=0;i<V;i++)
      {
          for(int j:adj.get(i))
          {
              al.get(j).add(i);
              indegree[i]++;
          }
      }
      List<Integer>res=new ArrayList<>();
      Queue<Integer>q=new LinkedList<>();
      for(int i=0;i<V;i++)
      {
          if(indegree[i]==0)
          q.add(i);
      }
      while(!q.isEmpty())
      {
          int curr=q.poll();
          res.add(curr);
          for(int it:al.get(curr))
          {
              indegree[it]--;
              if(indegree[it]==0)
              q.add(it);
          }
      }
      Collections.sort(res);
      return res;
    }
    
    
}
