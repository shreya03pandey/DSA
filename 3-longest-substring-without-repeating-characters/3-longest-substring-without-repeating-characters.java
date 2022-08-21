class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,maxi=0;
        HashMap<Character,Integer>h=new HashMap<>();
       while(r<s.length())
       {
           if(h.containsKey(s.charAt(r)))
           {
            l=Math.max(h.get(s.charAt(r))+1,l);//incase we have already discarded 
              
           }
            h.put(s.charAt(r),r);
            maxi=Math.max(maxi,r-l+1);
           r++;
       }
        return maxi;
    }
}