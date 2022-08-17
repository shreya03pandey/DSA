class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer>h=new HashSet<>();
        int res=0;
        for(int x:nums)
              h.add(x);
        for(int i=0;i<nums.length;i++)
        {
           int cnt=1;
            if(h.contains(nums[i]-1))
                continue;
            while(h.contains(nums[i]+cnt))
                cnt++;
           res=Math.max(res,cnt);     
        }
        return res;
    }
}