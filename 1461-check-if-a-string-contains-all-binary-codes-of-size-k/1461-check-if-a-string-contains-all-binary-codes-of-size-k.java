class Solution {
    public boolean hasAllCodes(String s, int k) {
      HashSet<String>h=new HashSet<>();
        int n=s.length();
        for(int i=0;i+k<=n;i++)
        {
          String st=s.substring(i,i+k);
            h.add(st);
        }
        if(h.size()==Math.pow(2,k))
            return true;
        else
            return false;
    }
}