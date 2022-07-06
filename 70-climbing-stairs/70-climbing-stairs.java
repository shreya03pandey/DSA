class Solution {
    public int climbStairs(int n) {
       int f=1,s=2;
        if(n<=2)
            return n;
        int res=0;
        for(int i=3;i<=n;i++)
        {
           res=f+s;
            f=s;
            s=res;
            
        }
        return res;
    }
}