class Solution {
    public int maxProduct(int[] nums) {
      int n=nums.length;
        int prod=1,maxP=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            prod*=nums[i];
            maxP=Math.max(maxP,prod);
            if(prod==0)
                prod=1;
        }
        prod=1;
        for(int i=n-1;i>=0;i--)
        {
            prod*=nums[i];
            maxP=Math.max(maxP,prod);
            if(prod==0)
                prod=1;
        }
        return maxP;
    }
}