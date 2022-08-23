class Solution {
    public boolean wordPattern(String pattern, String s) {
     HashMap<Character,String>m=new HashMap<>();
        HashSet<String>h=new HashSet<>();
        String arr[]=s.split(" ");
        if(pattern.length()!=arr.length)
            return false;
        for(int i=0;i<arr.length;i++)
        {
            if(m.containsKey(pattern.charAt(i)))
            {
                if(!m.get(pattern.charAt(i)).equals(arr[i]))
                {
                    return false;
                }
            }
            else
            {
                
                if(h.contains(arr[i]))
                   return false;
                m.put(pattern.charAt(i),arr[i]);
                    h.add(arr[i]);
            }
            
        }
        return true;
    }
}