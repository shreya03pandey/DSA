class Solution {
    public String reverseWords(String s) {
     char ch[]=s.toCharArray();
        int st=0;
        for(int e=0;e<s.length();e++)
        {
           if(Character.isWhitespace(s.charAt(e)))
           {
                reverse(ch,st,e-1);
                st=e+1;  
           }
           
        }
        reverse(ch,st,s.length()-1);
        return new String(ch);
    }
    public void reverse(char[] ch,int i,int j)
    {
       while(i<j)
       {
           char c=ch[i];
           ch[i]=ch[j];
           ch[j]=c;
           i++;
           j--;
       }
    }
}