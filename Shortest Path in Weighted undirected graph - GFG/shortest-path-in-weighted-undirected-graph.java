//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int dis,tar;
    Pair(int d,int t)
    {
        dis=d;
        tar=t;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<Integer>res=new ArrayList<>();
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((a,b)->a.dis-b.dis);
        ArrayList<ArrayList<Pair>>al=new ArrayList<>();
        for(int i=0;i<=n;i++)
        al.add(new ArrayList<Pair>());
        for(int i=0;i<m;i++)
        {
           al.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
           al.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        pq.add(new Pair(0,1));
        int parent[]=new int[n+1];
        for(int i=1;i<=n;i++)
        parent[i]=i;
        int dis[]=new int[n+1];
        Arrays.fill(dis,(int)(1e9));
        dis[1]=0;
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            int d=p.dis;
            int t=p.tar;
            for(Pair pr:al.get(t))
            {
                int newd=pr.dis;
                int newt=pr.tar;
                if(dis[newt]>dis[t]+newd)
                {
                    parent[newt]=t;
                    dis[newt]=dis[t]+newd;
                    pq.add(new Pair(dis[newt],newt));
                }
            }
        }
        
       
       if(dis[n]==1e9)
        {
            res.add(-1);
            return res;
        }
       
        int dest=n;
        while(parent[dest]!=dest)
        {
          res.add(dest);
          dest=parent[dest];
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }
}