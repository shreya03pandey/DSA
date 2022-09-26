class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>al=new ArrayList<>();
        for(int i=left;i<=right;i++)
            if(selfDivide(i))
                al.add(i);
        return al;
    }
    public boolean selfDivide(int n)
    {
        int dup=n;
        while(n>0)
        {
            int d=n%10;
                
            if(d==0||dup%d!=0)
                return false;
            n/=10;
        }
        return true;
    }
}