class Solution {
    public int removePalindromeSub(String s) {
     int n=s.length();
        if(isPalin(s))
            return 1;
        else
            return 2;
    }
    public boolean isPalin(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}