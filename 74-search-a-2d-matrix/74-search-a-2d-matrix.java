class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n=mat.length;
        int m=mat[0].length;
        int i=0,j=m*n-1;
        while(i<=j)
        {
            int mid=(i+j)>>1;
            int r=mid/m;
            int c=mid%m;
            if(mat[r][c]==target)
                return true;
            if(target<mat[r][c])
                j=mid-1;
            else
                i=mid+1;
        }
        return false;
    }
}