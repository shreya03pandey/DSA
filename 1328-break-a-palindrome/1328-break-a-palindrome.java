class Solution {
    public String breakPalindrome(String pal) {
        int n=pal.length();
         char ch[]=pal.toCharArray();
        if(n<=1)
            return "";
        for(int i=0;i<n/2;i++)
        {
            if(ch[i]!='a')
            {
                ch[i]='a';
                return String.valueOf(ch);
            }
        }
        ch[n-1]='b';
        return String.valueOf(ch);
    }
}