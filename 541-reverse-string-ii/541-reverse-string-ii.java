class Solution {
    public String reverseStr(String s, int k) {
        char ch[]=s.toCharArray();
        boolean flag=false;
        int i=0,lim=-1;
        
        while(i<s.length())
        {
            if(flag)
                i+=k;
            else
            {
                if(i+k-1<s.length())
                    lim=i+k-1;
                else
                    lim=s.length()-1;
                reverse(ch,i,lim);
                i+=k;
            }
            flag=!flag;
        }
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