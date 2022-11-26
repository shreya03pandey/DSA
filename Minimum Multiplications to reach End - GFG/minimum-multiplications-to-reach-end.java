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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int first,sec;
    Pair(int f,int s)
    {
        first=f;
        sec=s;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
       
        // Your code here
        int dis[]=new int[100000];
        Arrays.fill(dis,(int)(1e9));
        dis[start]=0;
        int mod=100000;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,start));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int steps=p.first;
            int num=p.sec;
            for(int i=0;i<arr.length;i++)
            {
                int mult=(num*arr[i])%mod;
                if(steps+1<dis[mult])
                {
                    dis[mult]=steps+1;
                    q.add(new Pair(dis[mult],mult));
                }
            }
        }
         if(dis[end]==1e9)
         return -1;
         else
         return dis[end];
    }
}
