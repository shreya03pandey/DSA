class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
      int rows=mat.length,cols=mat[0].length;
        int res[]= new int[rows*cols];
        boolean up=true;  
        int row=0,col=0,idx=0;
        
   while(row<rows && col < cols){
     if(up){
        while(row>0 && col< cols-1 ){
          res[idx++]=mat[row][col]; 
          row--;
          col++;
          }
          res[idx++]=mat[row][col];
          if(col==cols-1){
              row++;
          }else{
             col++; 
          }
         
        }
          else
          {
             while(row<rows-1 && col>0 ){
              res[idx++]=mat[row][col]; 
               row++;
               col--;
             }
            res[idx++]=mat[row][col];
            if(row==rows-1){
              col++;
             }else{
             row++; 
           } 
         }  
      up=!up;
    }
        return res;
  }
}



         
         