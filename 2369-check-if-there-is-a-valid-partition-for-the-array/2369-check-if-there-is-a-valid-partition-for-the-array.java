class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length-1;
        boolean dp[]=new boolean[n+1];
        return solve(nums,n,dp);
    }
    public boolean solve(int[] nums,int idx,boolean dp[])
    {
        if(idx<0)
            return true;
        if(dp[idx]!=false)
            return dp[idx];
        boolean res1=false;
        boolean res2=false;
        boolean res3=false;
        if(idx-1>=0)
        {
            if(nums[idx]==nums[idx-1])
                res1= solve(nums,idx-2,dp);
        }
        if(idx-2>=0)
        {
            if(nums[idx]==nums[idx-1]&&nums[idx-2]==nums[idx-1])
                res2= solve(nums,idx-3,dp);
        }
        if(idx-2>=0)
        {
            if((nums[idx]==(nums[idx-1]+1))&&((nums[idx-2]+1)==nums[idx-1]))
                res3= solve(nums,idx-3,dp);
        }
        return dp[idx]=res1||res2||res3;
    }
}