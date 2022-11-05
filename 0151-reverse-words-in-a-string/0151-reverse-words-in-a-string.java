class Solution {
    public String reverseWords(String st) {
        StringBuilder word=new StringBuilder();
        StringBuilder sen=new StringBuilder();
        for(int i=st.length()-1;i>=0;i--)
        {
            char ch=st.charAt(i);
            if(ch==' ')
            {
                if(word.length()==0) continue;
                if(sen.length()>0) sen.append(' ');
                sen.append(word.reverse());
                word=new StringBuilder();
            }
            else
            {
                word.append(ch);
            }
        }
        if(word.length()>0)
        {
        if(sen.length()>0) sen.append(' ');
                sen.append(word.reverse());
        }
        return sen.toString();
    }
}
    