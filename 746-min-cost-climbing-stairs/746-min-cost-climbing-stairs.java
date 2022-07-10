class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
       int n=cost.length;
        dp=new int[n];
        return Math.min(f(cost,n-1),f(cost,n-2));
    }
    public int f(int[] cost,int n)
    {
        if(n==0||n==1) return cost[n];
        if(dp[n]!=0) return dp[n];
        int jump1=f(cost,n-1);
        int jump2=f(cost,n-2);
        dp[n]= cost[n]+Math.min(jump1,jump2);
        return dp[n];
    }
}