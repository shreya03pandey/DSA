class Solution {
    public int fillCups(int[] amt) {
        int mx=0;
        int sum=0;
        for(int x:amt)
        {
            sum+=x;
            mx=Math.max(mx,x);
        }
        return  Math.max(mx,(int)Math.ceil(sum*0.5));
    }
}