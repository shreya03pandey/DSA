// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> pattern(int N){
        // code here
         List<Integer>al=new ArrayList<Integer>();
         al.add(N);
         boolean f=true;
         check(al,N,N,f);
         return al;
    }
    static void check(List<Integer>al,int n,int val,boolean f)
    {
        if(val<=0)
           f=false;
           
           val=(f==true)?val-5:val+5;
           if(val>n)
           return ;
           al.add(val);
           check(al,n,val,f);
        
        
    }
}