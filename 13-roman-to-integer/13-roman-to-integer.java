class Solution {
    public int romanToInt(String s) {
        int l=s.length();
     Map<Character,Integer>m=new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
       int res=m.get(s.charAt(l-1));
        for(int i=l-2;i>=0;i--)
        {
            if(m.get(s.charAt(i))<m.get(s.charAt(i+1)))
                res-=m.get(s.charAt(i));
            else
                res+=m.get(s.charAt(i));
        }
       return res; 
    }
}