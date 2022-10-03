class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
       int m=mat.length;
        int n=mat[0].length;
        for(int diff=(m-1);diff>=-(n-1);diff--)
        {
            int row=0,col=0;
            if(diff>0) row=diff;
            if(diff<0) col=-diff;
            int prev=mat[row][col];
             while(row<m||col<n)
            {
              row++;
              col++;
               if(row<m&&col<n&&mat[row][col]!=prev)
                return false;
              }
        }
        return true;
    }
 }     
// 0 1 2 3
//     0  1 2 3 4
//     1  5 1 2 3
//     2  9 5 1 2
//     diff=row-col
//    diff range-2,1,0 -1 -2 -3  -(n-1)
//     m-1 to -(n-1)
//     for(int diff=m-1;diff>=-(n-1);diff--)
//     {
//     diff(+ve)-> col=0,row=diff
//     diff(-ve)-> row=0,col=-diff
//     prev=mat[row][col];
//         while(row<n&&col<n)
//         {
//          row++;
//          col++;
//             if(mat[row][col]!=prev)
//                 return false;
//         }
//       return true;  