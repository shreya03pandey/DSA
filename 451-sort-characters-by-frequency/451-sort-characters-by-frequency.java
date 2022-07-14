class Solution {
    public String frequencySort(String s) {
      HashMap<Character,Integer>m=new HashMap<>();
        for(int i=0;i<s.length();i++)
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        int max=0;
        for(char c:m.keySet())
        {
          if(max<m.get(c))
              max=m.get(c);
        }
       ArrayList<Character> arr[]=new ArrayList[max+1];
        //creating array of arrayList
         for(char c:m.keySet())
         {
             int freq=m.get(c);
             if(arr[freq]==null)
                 arr[freq]=new ArrayList<>();
             
                 arr[freq].add(c);
         }
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]!=null)
            {
                for(char c:arr[i])
                {
                    for(int j=0;j<i;j++)
                    {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
        
    }
}