class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int max=0;
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<n;i++)
            h.add(nums[i]);
           for(int i=0;i<n;i++)
           {
               
               int cnt=1;
               int res=1;
               if(!h.contains(nums[i]-1))
               {
               while(h.contains(nums[i]+cnt))
               {
                  res++;
                   cnt++;
               }
               }
               max=Math.max(max,res);
           }  
         return max;  
    }
}