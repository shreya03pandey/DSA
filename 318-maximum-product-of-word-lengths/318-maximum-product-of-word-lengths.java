class Solution {
    public int maxProduct(String[] words) {
      int n=words.length;
        int bitmask[]=new int[n];
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
              int c=words[i].charAt(j)-'a';
                bitmask[i]|=(1<<c);
            }
            for(int j=0;j<i;j++)
            {
                if((bitmask[i]&bitmask[j])==0)
                res=Math.max(res,words[i].length()*words[j].length());
            }
        }
        return res;
    }
}