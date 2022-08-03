class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
     int l=mat[0][0];
     int r=mat[m-1][n-1];
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(check(mat,mid)<k)
                l=mid+1;
            else
                r=mid-1;
        }
        return l;
    }
    public int check(int[][] mat,int tar)
    {
        int cnt=0;
        int n=mat.length;
        int i=0,j=n-1;
        while(i<n&&j>=0)
        {
          if(mat[i][j]>tar)
          {
              j--;
          }
            else
            {
                cnt+=j+1;
                i++;
                
            }
        }
        return cnt;
    }
}