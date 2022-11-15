class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
      int ps[]=new int[n];
      int ns[]=new int[n];
        previousSmall(heights,ps);
        nextSmall(heights,ns);
        int res=0;
        for(int i=0;i<n;i++)
           res=Math.max(res,(ns[i]-ps[i]-1)*heights[i]); 
        return res;
    }
    public void previousSmall(int[] heights,int ps[])
    {
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])
                s.pop();
            ps[i]=(s.isEmpty())?-1:s.peek();
            s.push(i);
        }
       
    }
    public void nextSmall(int[] heights,int ns[])
    {
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])
                s.pop();
            ns[i]=(s.isEmpty())?n:s.peek();
            s.push(i);
        }
         
    }
}