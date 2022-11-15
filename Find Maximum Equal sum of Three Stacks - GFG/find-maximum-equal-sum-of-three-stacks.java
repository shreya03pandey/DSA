//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int h1=0,h2=0,h3=0;
        for(int x:S1)
        h1+=x;
        for(int x:S2)
        h2+=x;
        for(int x:S3)
        h3+=x;
        int k1=0,k2=0,k3=0;
        while(k1!=N1&&k2!=N2&&k3!=N3)
        {
            if(h1==h2&&h2==h3)
            return h1;
             if(h1>=h2&&h1>=h3)
             h1-=S1[k1++];
             else
             if(h2>=h1&&h2>=h3)
             h2-=S2[k2++];
             else
             if(h3>=h2&&h3>=h1)
             h3-=S3[k3++];
            
        }
        return 0;
        
    }
}
        
