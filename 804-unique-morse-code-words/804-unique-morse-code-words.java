class Solution {
    public int uniqueMorseRepresentations(String[] words) {
      int n=words.length;
        String s[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String>h=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            String ans="";
            for(int j=0;j<words[i].length();j++)
            {
                ans+=s[words[i].charAt(j)-'a'];
            }
            h.add(ans);
        }
        return h.size();
    }
}