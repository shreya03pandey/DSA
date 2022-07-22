class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
     //finding gcd of the array elements
        int g=numsDivide[0];
        for(int x:numsDivide)
            g=gcd(x,g);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
            if(g%nums[i]==0)
                return i;
        return -1;
    }
    public int gcd(int a,int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}