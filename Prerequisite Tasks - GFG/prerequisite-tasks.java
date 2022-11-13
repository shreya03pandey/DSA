//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java
//checkout this example-
// 1 2
// 4 3
// 2 4
// 4 1
class Solution {
    public boolean isPossible(int N, int[][] pre)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++)
        adj.get(pre[i][0]).add(pre[i][1]);
        
        int indegree[]=new int[N];
        int res[]=new int[N];
        int k=0;
        for(int i=0;i<N;i++)
        {
            for(int it:adj.get(i))
            indegree[it]++;//calculating indegrees takes care of disconnected components 
            //no need to handle explicitly
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<N;i++)
        if(indegree[i]==0)
        q.add(i);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            res[k++]=curr;
            for(int it:adj.get(curr))
            {
                indegree[it]--;
                if(indegree[it]==0)
                q.add(it);
            }
        }
        if(k==N)
        return true;
        else
        return false;
    }
    
}