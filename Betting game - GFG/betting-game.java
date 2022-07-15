// { Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String result = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.betBalance(result));
        }
    }
}// } Driver Code Ends


// User function template for Java
class Solution
{
    static int betBalance(String res)
    {
        // code here
        int bet=1;
        int sum=4;
        for(int i=0;i<res.length();i++)
        {
            if(sum<bet)
            return -1;
          if(res.charAt(i)=='W')
          {
              sum+=bet;
              bet=1;
          }
          else
          {
              sum-=bet;
              if(sum<0)
              return -1;
              bet=2*bet;
          }
        }
        return sum;
    }
}