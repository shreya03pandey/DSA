class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer>al=new ArrayList<Integer>();
         //there can  be at max 2 n/3 majority element
        int res1=0;
        int res2=1;
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==nums[res1])
                cnt1++;
            else 
                if(nums[i]==nums[res2])
                cnt2++;
            
              else if(cnt1==0)
                {
                    res1=i;
                  cnt1=1;
                }
            else
                if(cnt2==0)
                {
                    res2=i;
                    cnt2=1;
                }
            else
            {
               cnt1--;
               cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int x:nums)
        {
            if(x==nums[res1])
                cnt1++;
            else
            if(x==nums[res2])
                cnt2++;
        }
        if(cnt1>n/3) al.add(nums[res1]);
         if(cnt2>n/3) al.add(nums[res2]);
        return al;
    }
}