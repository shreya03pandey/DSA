class Solution {
    public boolean canChange(String start, String target) {
       int i=0,j=0;
        int n=start.length();
        int m=target.length();
        if(n!=m)
            return false;
        
        while (i < start.length() || j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }
            
            if (i == j && i == start.length()) {
                return true;
            }
            
            if (i == start.length() || j == target.length() || start.charAt(i) !=      target.charAt(j)) {
                return false;
            }
            
            
            if ((target.charAt(j) == 'L' && i < j) || (target.charAt(j) == 'R' && i > j)) {
                return false;
            }
            
            i++;
            j++;
        }
        
        return true;
    }
}