class Solution {
    public double myPow(double x, int n) {
    
        if(n<0){
          x=1.0/x;
            }
        double res=1.0;
        while(n!=0)
        {
            if(n%2!=0)
                res*=x;
            n/=2;
            x*=x;
        }
        return res;
    }
}