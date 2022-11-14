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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>>al=new ArrayList<>();
        for(int i=0;i<n;i++)
        al.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        int dis[]=new int[n];
        Arrays.fill(dis,(int)(1e9));
        dis[src]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty())
        {
            int v=q.poll();
            for(int it:al.get(v))
            {
                if(dis[it]>dis[v]+1){
                dis[it]=dis[v]+1;
                q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++)
        if(dis[i]==1e9)
        dis[i]=-1;
        return dis;
    }
}