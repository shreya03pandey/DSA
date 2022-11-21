class Solution {
    public int[] asteroidCollision(int[] ast) {
      Stack<Integer>st=new Stack<>();
        for(int x:ast)
        {
            if(x>0)
            {
                st.push(x);
            }
            else
            {
               while(!st.isEmpty()&&st.peek()>0&&st.peek()<Math.abs(x))
                   st.pop();//if stack peek is lesser in size
               if(st.isEmpty()||st.peek()<0)
                   st.push(x);//if stack is empty or peek value is negative
                else
                    if(st.peek()==Math.abs(x))
                        st.pop();//if stack peek 
            }
        }
        int n=st.size();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--)
            res[i]=st.pop();
        return res;
    }
}
