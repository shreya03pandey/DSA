class Solution {
    public int reverse(int x) {
      long var=0L;
        while(x!=0)
        {
            int d=x%10;
            var=var*10+d;
            x=x/10;
        }
        if(var>=Integer.MIN_VALUE&&var<=Integer.MAX_VALUE)
            return (int)var;
        else
            return 0;
    }
}