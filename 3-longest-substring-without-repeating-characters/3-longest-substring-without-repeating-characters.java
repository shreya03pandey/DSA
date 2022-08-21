class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,maxi=0;
        HashSet<Character>h=new HashSet<>();
       while(r<s.length())
       {
           if(h.contains(s.charAt(r)))
           {
             h.remove(s.charAt(l)); 
               l++;
           }
           else
           {
               h.add(s.charAt(r));
               r++;
               maxi=Math.max(maxi,h.size());
           }
           
       }
        return maxi;
    }
}