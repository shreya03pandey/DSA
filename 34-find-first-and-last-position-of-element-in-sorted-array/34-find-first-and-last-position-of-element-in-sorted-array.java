class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        res[0]=findRes(nums,target,false);
        res[1]=findRes(nums,target,true);
        return res;
    }
    public int findRes(int[] nums, int target,boolean isLast)
    {
        int n=nums.length;
        int re=-1;
        int b=0,e=n-1;
        while(b<=e)
        {
           
            int mid=(b+e)/2;
            if(nums[mid]==target)
            {
                re=mid;
                if(isLast)
                    b=mid+1;
                else
                    e=mid-1;
            }
           
            if(nums[mid]<target)
                b=mid+1;
               else
                 if(nums[mid]>target)
                e=mid-1;
        }
        return re;
    }
}