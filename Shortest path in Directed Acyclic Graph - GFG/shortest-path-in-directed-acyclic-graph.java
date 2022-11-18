//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair
{
    int v;
    int d;
    Pair(int ver,int dis)
    {
        v=ver;
        d=dis;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>>al=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
		 
		al.add(new ArrayList<Pair>());
		}
		for(int i=0;i<M;i++)
		{
		    al.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		Stack<Integer>st=new Stack<>();
		int vis[]=new int[N];
		for(int i=0;i<N;i++){
		if(vis[i]==0)
		topoSort(al,i,st,vis);
		}
		int dis[]=new int[N];
		
		Arrays.fill(dis,(int)(1e9));
	     dis[0]=0;
		while(!st.isEmpty())
		{
		    int u=st.pop();
		    for(Pair p:al.get(u))
	           {
	               int val=p.v;
	               int wt=p.d;
	               dis[val]=Math.min(dis[val],dis[u]+wt);
	           }
		}
		for(int i=0;i<dis.length;i++)
		{
		if(dis[i]==1e9)
		dis[i]=-1;
		}
		return dis;
		
	}
	public void topoSort(ArrayList<ArrayList<Pair>>al,int u,Stack<Integer>st,int vis[])
	{
	    vis[u]=1;
	    for(Pair p:al.get(u))
	    {
	        int curr=p.v;
	        if(vis[curr]==0)
	        topoSort(al,curr,st,vis);
	    }
	    st.push(u);
	}
}