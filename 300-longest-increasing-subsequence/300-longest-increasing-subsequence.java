class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return findMax(nums,nums.length-1,-1,dp);
    }
    public int findMax(int[] nums,int idx,int prev,int[][] dp)
    {
        if(idx<0)
            return 0;
        if(prev!=-1&&dp[idx][prev]!=-1)
            return dp[idx][prev];
        int nopick=findMax(nums,idx-1,prev,dp);
        int pick=0;
        if(prev==-1 || nums[idx]<nums[prev])
            pick=1+findMax(nums,idx-1,idx,dp);
        if(prev!=-1)
        return dp[idx][prev]=Math.max(pick,nopick);
        return Math.max(pick,nopick);
    }
}