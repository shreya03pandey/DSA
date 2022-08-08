class Solution {
    public int lengthOfLIS(int[] nums) {
       List<Integer>al=new ArrayList<>();
        al.add(nums[0]);
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
          if(nums[i]>al.get(al.size()-1))
              al.add(nums[i]);
            else
            {
                int idx=binarySearch(al,nums[i]);
                al.set(idx,nums[i]);
            }
        }
        return al.size();
    }
     
      public int binarySearch(List<Integer>al,int tar)
      {
          int l=0,r=al.size()-1;
          while(l<=r)
          {
              int mid=(l+r)/2;
              if(al.get(mid)==tar)
                  return mid;
              if(al.get(mid)<tar)
                  l=mid+1;
              else
                  r=mid-1;
          }
          return r+1;
      }
   
}