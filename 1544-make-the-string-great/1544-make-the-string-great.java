class Solution {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        Stack<Character>st=new Stack<>();
        st.push(s.charAt(n-1));
        for(int i=n-2;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(!st.isEmpty()&&Math.abs(ch-st.peek())==32)
            {
                st.pop();
                continue;
            }
            st.push(ch);
            
        }
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }
}