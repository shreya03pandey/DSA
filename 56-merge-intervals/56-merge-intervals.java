class Solution {
    public int[][] merge(int[][] in) {
       int res=0;
        Arrays.sort(in, (a,b) -> a[0] - b[0]);
    
        for(int i=1;i<in.length;i++)
        {
            if(in[res][1]>=in[i][0])
            {
                in[res][1]=Math.max(in[res][1],in[i][1]);
            }
            else
            {
                 res++;
                in[res]=in[i];
            }
          
        }
        int r[][]=new int[res+1][2];
        for(int i=0;i<=res;i++){
            r[i][0]=in[i][0];
            r[i][1]=in[i][1];
        }
        return r;
      
    }
}