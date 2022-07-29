class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
       List<String>  res=new ArrayList<String>();
       for(String w:words)
           if(check(w,pattern)==true)
               res.add(w);
        return res;
    }
    public boolean check(String x,String y)
    {
        for(int i=0;i<x.length();i++)
        {
            if(x.indexOf(x.charAt(i))!=y.indexOf(y.charAt(i)))
                return false;
        }
        return true;
    }
}