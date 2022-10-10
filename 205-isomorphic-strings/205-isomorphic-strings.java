class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>mp=new HashMap<>();
        int n=s.length(),m=t.length();
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(s.charAt(i)) && mp.get(s.charAt(i))!=t.charAt(i))
             return false;
             if(mp.containsKey(s.charAt(i)) && mp.get(s.charAt(i))==t.charAt(i))
             continue;
             if(mp.containsValue(t.charAt(i)))
                return false;
            mp.put(s.charAt(i),t.charAt(i));    
        }
        return true;
    }
}