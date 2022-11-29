//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int knows[]=new int[n];
    	int known[]=new int[n];
    	for(int i=0;i<n;i++)
    	{
    	    for(int j=0;j<n;j++)
    	    {
    	        if(M[i][j]==1)
    	        {
    	            knows[i]++;
    	            known[j]++;
    	        }
    	    }
    	}
    	for(int i=0;i<n;i++)
    	{
    	    if(knows[i]==0&&known[i]==n-1)
    	    return i;
    	}
    	return -1;
    }
}      
// mat[]=0 {0,1,1,0}
//       1 {1,0,1,0}
//       2 {0,0,0,0}
//       3 {0,0,1,0} 
//           0,1,2,3
// knows[4]={2 2 0 1}->rows
// known[4]={1 1 3 0}->col
      
//  mat[0][1] 
//  mat[0][2]
//  mat[1][0]
//  mat[1][2]
//  mat[3][2]
   