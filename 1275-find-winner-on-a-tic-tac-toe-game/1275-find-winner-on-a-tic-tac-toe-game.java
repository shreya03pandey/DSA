class Solution {
    public String tictactoe(int[][] moves) {
      char start='X';
        char mat[][]=new char[3][3];
        for(int i=0;i<moves.length;i++)
        {
          int x=moves[i][0];
          int y=moves[i][1];
            mat[x][y]=start;
            if(win(mat,start))
            {
                if(start=='X')
                    return "A";
                else
                    return "B";
            }
            if(start=='X')
                start='O';
            else
                start='X';
            
        }
        if(moves.length==9)
            return "Draw";
        else
            return "Pending";
    }
    public boolean win(char mat[][],char st)
    {
        if(mat[0][0]==st&&mat[1][1]==st&&mat[2][2]==st)
            return true;
        if(mat[0][2]==st&&mat[1][1]==st&&mat[2][0]==st)
            return true;
        if(mat[0][0]==st&&mat[0][1]==st&&mat[0][2]==st)
            return true;
        if(mat[1][0]==st&&mat[1][1]==st&&mat[1][2]==st)
            return true;
        if(mat[2][0]==st&&mat[2][1]==st&&mat[2][2]==st)
            return true;
        if(mat[0][0]==st&&mat[1][0]==st&&mat[2][0]==st)
            return true;
        if(mat[0][1]==st&&mat[1][1]==st&&mat[2][1]==st)
            return true;
        if(mat[0][2]==st&&mat[1][2]==st&&mat[2][2]==st)
            return true;
        return false;
    }
}
 