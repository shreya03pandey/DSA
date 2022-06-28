class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        int del=0;
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<26;i++)
        {
           while(freq[i]!=0 && h.contains(freq[i]))
           {
             freq[i]--;
               del++;
           }
            h.add(freq[i]);
        }
        return del;
    }
}