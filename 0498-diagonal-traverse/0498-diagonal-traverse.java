class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
      int rows=mat.length,cols=mat[0].length;
        int res[]= new int[rows*cols];
        boolean up=true;  
        int row=0,col=0,idx=0;
        
      while(idx<rows*cols){
        if(up){
        while(row>0 && col< cols-1 ){
          res[idx]=mat[row][col]; 
          idx++;
          row--;
          col++;       
          }     
            res[idx++]=mat[row][col];
          if(col<cols-1){
              col++;
          }else{
             row++; 
          }
         
        }
          else
          {
             while(row<rows-1 && col>0 ){
              res[idx]=mat[row][col]; 
                 idx++;
               row++;
               col--;
             }
            res[idx++]=mat[row][col];
            if(row<rows-1){
              row++;
             }else{
             col++; 
           } 
         }  
      up=!up;
    }
        return res;
  }
}
// row,col
// up=true-->
//     col+1<cols
//     col++;
//     else
//     row++;
// down-->
//     row+1<rows
//     row++;
//     else
//     col++;


         
         