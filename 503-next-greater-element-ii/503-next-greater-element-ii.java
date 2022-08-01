class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Stack<Integer>s=new Stack();
        s.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            
            s.push(i);
        }
        int k=n-1;
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty()&&nums[s.peek()]<=nums[i])
                s.pop();
            if(s.isEmpty())
                res[k--]=-1;
            else
                res[k--]=nums[s.peek()];
            s.push(i);
        }
        return res;
    }
}