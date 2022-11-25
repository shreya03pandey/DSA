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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair
{
    int des,wt;
    Pair(int des,int wt)
    {
        this.des=des;
        this.wt=wt;
    }
}
class Triplet
{
    int stop,dis,dnode;
    Triplet(int stop,int dis,int dnode)
    {
        this.stop=stop;
        this.dis=dis;
        this.dnode=dnode;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>>al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++)
        {
          al.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));  
        }
        Queue<Triplet>q=new LinkedList<>();
        q.add(new Triplet(0,0,src));
        int dis[]=new int[n];
        Arrays.fill(dis,(int)(1e9));
        dis[src]=0;
        while(!q.isEmpty())
        {
            Triplet t=q.poll();
            int stops=t.stop;
            int dist=t.dis;
            int desnode=t.dnode;
            for(Pair p:al.get(desnode))
            {
                if(p.wt+dist<dis[p.des]&&stops<=k)
                {
                    dis[p.des]=dist+p.wt;
                    q.add(new Triplet(stops+1,dis[p.des],p.des));
                }
            }
        }
        if(dis[dst]==1e9)
        return -1;
        else
        return dis[dst];
    }
}