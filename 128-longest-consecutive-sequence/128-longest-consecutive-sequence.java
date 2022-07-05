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
             int prev=nums[i]-1;
               int next=nums[i]+1;
               while(h.contains(prev))
               {
                 cnt++;
                   h.remove(prev);
                   prev--;
               }
                while(h.contains(next))
               {
                 cnt++;
                    h.remove(next);
                   next++;
               }
               max=Math.max(max,cnt);
           }  
         return max;  
    }
}