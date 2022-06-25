class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int minsp=1,maxsp=getMax(piles);
        int ans=-1;
        while(minsp<=maxsp)
        {
            int mid=(minsp+maxsp)/2;
            if(gethours(piles,mid)<=h)
            {
                ans=mid;
                maxsp=mid-1;
            }
            else
               minsp=mid+1;
        }
        return ans;
    }
    public int getMax(int[] piles)
    {
        int max=piles[0];
        for(int i=1;i<piles.length;i++)
            if(piles[i]>max)
                max=piles[i];
        return max;
    }
    public int gethours(int piles[],int speed)
    {
        int hr=0;
        for(int i=0;i<piles.length;i++)
        {
          hr+=Math.ceil(piles[i]/(speed*1.0));
        }
        return hr;
    }
}