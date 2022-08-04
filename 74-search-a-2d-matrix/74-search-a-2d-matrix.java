class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n=mat.length;
        int m=mat[0].length;
      int i=0,j=m-1;
        while(j>=0&&i<n)
        {
            if(target==mat[i][j])
                return true;
            if(target<mat[i][j])
                j--;
            else
                i++;
        }
        return false;
    }
}