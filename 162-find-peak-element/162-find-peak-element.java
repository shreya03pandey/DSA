class Solution {
    public int findPeakElement(int[] nums) {
      
        int s=0,e=nums.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if((mid==0||nums[mid]>nums[mid-1])&&(mid==nums.length-1||nums[mid]>nums[mid+1]))
                return mid;
            else
                if(mid!=0 && nums[mid-1]>nums[mid])
                    e=mid-1;
              else
                  s=mid+1;
        }
        return -1;
    }
}