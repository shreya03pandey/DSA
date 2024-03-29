class Solution {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        Stack<Character>st=new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<n;i++)
        {
            char ch=s.charAt(i);
            if(!st.isEmpty()&&Math.abs(ch-st.peek())==32)
                st.pop();
            else
            st.push(ch);
            
        }
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}