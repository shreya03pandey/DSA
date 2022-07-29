class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<m;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++)
        {
            int x=0,y=m-1;
            while(x<=y)
            {
                int temp=matrix[i][x];
                matrix[i][x]=matrix[i][y];
                matrix[i][y]=temp; 
                x++;
                y--;
            }
        }
   
    }
}