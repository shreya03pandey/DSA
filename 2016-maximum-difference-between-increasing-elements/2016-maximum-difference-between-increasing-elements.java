class Solution {
    public int maximumDifference(int[] nums) {
       int min=nums[0];
        int res=-1;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[j]>min)
                res=Math.max(res,nums[j]-min);
            min=Math.min(min,nums[j]);
        }
        return res;
    }
}
