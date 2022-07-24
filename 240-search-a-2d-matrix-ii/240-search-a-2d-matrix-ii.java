class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int i=0,j=matrix[0].length-1;
        while(j>=0&&i<matrix.length)
        {
            if(target>matrix[i][j])
                i++;
            else
                if(target<matrix[i][j])
                    j--;
            else
                return true;
        }
        return false;
    }
}