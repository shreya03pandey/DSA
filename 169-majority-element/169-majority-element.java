class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
       int cnt=1,res=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[res])
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
            if(cnt==0)
            {
                cnt=1;
                res=i;
            }
        }
         cnt=0;
        for(int i=0;i<n;i++)
            if(nums[i]==nums[res])
                cnt++;
             if(cnt<=n/2)
                 return -1;
        return nums[res];
    }
}