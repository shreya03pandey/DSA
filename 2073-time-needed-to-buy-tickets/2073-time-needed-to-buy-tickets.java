class Solution {
    public int timeRequiredToBuy(int[] tick, int k) {
       int res=0;
        for(int i=0;i<tick.length;i++)
        {
            if(tick[i]<tick[k])
                res+=tick[i];
            else
            {
                 res+=tick[k];
                if(i>k)
                    res-=1;
            }
        }
        
        return res;
    }
}