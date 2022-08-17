class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer>h=new HashSet<>();
        int res=0;
        for(int x:nums)
              h.add(x);
        for(int i=0;i<nums.length;i++)
        {
            int cnt=1,l=nums[i]+1,f=nums[i]-1;
            while(h.size()>0 && h.contains(f))
            {
                cnt++;
                h.remove(f);
                f--;
                
            }
            while(h.size()>0 && h.contains(l))
            {
                cnt++;
                h.remove(l);
                l++;
                
            }
          
           res=Math.max(res,cnt);     
        }
        return res;
    }
}