class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
       List<Integer>al=new ArrayList<>();
        TreeMap<String,Integer>m=new TreeMap<>();
        int n=words.length;
        for(String si:words)
         m.put(si,m.getOrDefault(si,0)+1);
        
         int ws=words[0].length();
         int size=n*ws;
        if(size>s.length())
            return al;
        for(int i=0;i<=s.length()-size;i++)
        {
           String st=s.substring(i,i+size);
            
            if(isEqual(st,new TreeMap<>(m),ws))
            {
                al.add(i);
            }
        }
        return al;
    }
    public boolean isEqual(String s,TreeMap<String,Integer>m,int ws)
    {
        for(int i=0;i<s.length();i+=ws)
        {
            String st=s.substring(i,i+ws);
            if(m.containsKey(st)&&m.get(st)>0){
                 m.put(st,m.get(st)-1);
            }
            else
            {
                return false;
                   
            }
        }
        return true;
    }
}