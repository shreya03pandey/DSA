class Solution {
    public String removeOuterParentheses(String s) {
       Stack<Character>st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int start=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
          char c=s.charAt(i);
          if(c=='(')
              st.push(c);
            else
            {
                st.pop();
                if(st.isEmpty() &&  i!=n)
                {
                    sb.append(s.substring(start+1,i));
                    start=i+1;
                }
            }
        }
        return sb.toString();
    }
}