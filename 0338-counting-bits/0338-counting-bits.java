class Solution {
    public int[] countBits(int n) {
       int res[]=new int[n+1]; 
        int k=1;
        res[0]=0;
        for(int i=1;i<=n;i=k)
        {
            for(int j=0;j<i;j++)
                if(k<=n)
                res[k++]=res[j]+1;
            if(k>n)
                break;
        }
       return res; 
    }
   
}