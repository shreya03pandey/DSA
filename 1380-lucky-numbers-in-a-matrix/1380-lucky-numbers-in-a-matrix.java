class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        List<Integer>res=new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            int minCol=mininRow(mat,i);
            int maxRow=maxinCol(mat,minCol);
            if(maxRow==i)
            {
                res.add(mat[i][minCol]);
                break;
            }
        }
        return res;
    }
    public int mininRow(int[][] mat,int row)
    {
        int minIdx=0;
        for(int i=1;i<mat[0].length;i++)
        {
            if(mat[row][i]<mat[row][minIdx])
                minIdx=i;
        }
        return minIdx;
    }
    public int maxinCol(int[][] mat,int col)
    {
        int maxIdx=0;
        for(int i=1;i<mat.length;i++)
        {
            if(mat[i][col]>mat[maxIdx][col])
                maxIdx=i;
        }
        return maxIdx;
    }
}