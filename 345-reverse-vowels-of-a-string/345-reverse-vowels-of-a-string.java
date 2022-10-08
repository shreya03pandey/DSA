class Solution {
    
    public String reverseVowels(String s) {
        char ch[]=s.toCharArray();
        int i=0,j=s.length()-1;
        String check="aeiouAEIOU";
        while(i<j)
        {
            while((i<j)&&(check.indexOf(ch[i])==-1))
                i++;
             while((i<j)&&(check.indexOf(ch[j])==-1))
                j--;
            
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
        return new String(ch);
    }
}