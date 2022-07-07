class Solution {
    public String removeOuterParentheses(String s) {
        int o=0,c=0,st=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                o++;
            else
                c++;
            if(o==c)
            {
                sb.append(s.substring(st+1,i));
                st=i+1;
            }
        }
        return sb.toString();
    }
}