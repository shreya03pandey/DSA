class Solution {
    public int lengthOfLIS(int[] nums) {
      List<Integer>al=new ArrayList<>();
        int n =nums.length;
        int res=1;
        al.add(nums[0]);
        for(int i=1;i<n;i++)
        {
            if(nums[i]>al.get(al.size()-1))
            {
               al.add(nums[i]);
                res++;
            }
            else
            {
                int idx=binary(al,nums[i]);
                al.set(idx,nums[i]);
            }
        }
        return res;
    }
    public int binary(List<Integer>al,int tar)
    {
        int l=0,r=al.size()-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(al.get(mid)<tar)
                l=mid+1;
            else
                r=mid-1;
        }
        return r+1;
    }
}