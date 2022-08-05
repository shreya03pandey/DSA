class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[][]=new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
       return solve( nums,target,0,nums.length,dp); 
    }
    public int solve(int[] nums,int tar,int idx,int n,int[][] dp)
    {
        if(tar==0)
            return 1;
        if(idx==n||tar<0)
            return 0;
          if(dp[idx][tar]!=-1)
              return dp[idx][tar];
        
        int pick=0;
        if(nums[idx]<=tar)
        pick=solve(nums,tar-nums[idx],0,n,dp);
        int nopick=solve(nums,tar,idx+1,n,dp);
        return dp[idx][tar]=pick+nopick;
    }
}