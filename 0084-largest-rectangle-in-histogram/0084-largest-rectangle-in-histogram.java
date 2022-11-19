class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int ps[]=new int[n];
        int ns[]=new int[n];
        findPreviousSmall(heights,ps);
        findNextSmall(heights,ns);
        int maxarea=0;
        for(int i=0;i<n;i++)
        {
            int l=heights[i];
            int b=ns[i]-ps[i]-1;
            maxarea=Math.max(maxarea,l*b);
        }
        return maxarea;
    }
    public void findPreviousSmall(int[] heights,int[] ps)
    {
        Stack<Integer>st=new Stack<>();//fill indexes in this array
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            ps[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
    }
    public void findNextSmall(int[] heights,int[] ns)
    {
        Stack<Integer>st=new Stack<>();//fill indexes in this array
        int n=heights.length;
        for(int i=heights.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            ns[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
    }
}


            
    
    