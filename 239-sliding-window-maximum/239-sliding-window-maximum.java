class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        Deque<Integer>dq=new LinkedList<>();
        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            dq.addLast(i);
        }
        for(int i=k;i<n;i++)
        {
          res[i-k]=nums[dq.peek()]; 
             while(!dq.isEmpty() && dq.peek()<=i-k)
                dq.pollFirst();
             while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            dq.addLast(i);
        }
        res[n-k]=nums[dq.peek()];
        return res;
    }
}