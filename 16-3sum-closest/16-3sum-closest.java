class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int mindiff=Integer.MAX_VALUE;
        int close=0;
        for(int i=0;i<n-2;i++)
        {
           int f=i+1,b=n-1;
            while(f<b)
            {
                int sum=nums[i]+nums[f]+nums[b];
                int diff=Math.abs(target-sum);
                if(diff<mindiff)
                {
                    close=sum;
                    mindiff=diff;
                }
                    if(sum>target)
                        b--;
                else
                    f++;
            }
        }
        return close;
    }
}