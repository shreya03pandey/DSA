class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2) return 1;
       int f=0,s=1,t=1;
        int res=0;
        for(int i=3;i<=n;i++)
        {
             res=f+s+t;
            f=s;
            s=t;
            t=res;
        }
        return res;
    }
}