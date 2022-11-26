//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int first, sec;
    Pair(int f,int s)
    {
        first=f;
        sec=s;
    }
}
class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        int mod=(int)(1e9+7);
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<roads.size();i++)
        {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.first-b.first);
        int dis[]=new int[n];
        int ways[]=new int[n];
        ways[0]=1;
        Arrays.fill(dis,(int)(1e9));
        dis[0]=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
         Pair cur=pq.poll();
         int d=cur.first;
         int nod=cur.sec;
         for(Pair x:adj.get(nod))
         {
             int ver=x.first;
             int wt=x.sec;
             if(wt+d<dis[ver])
             {
                 dis[ver]=wt+d;
                 ways[ver]=ways[nod];
                 pq.add(new Pair(dis[ver],ver));
             }
             else
             if(wt+d==dis[ver])
             ways[ver]=(ways[ver]+ways[nod])%mod;
         }
        }
        return ways[n-1]%mod;
    }
}
