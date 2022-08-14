class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        HashSet<String>h=new HashSet<>();
        
        for(String w:wordList)
        {
            h.add(w);
        }
        if(!h.contains(end))
            return 0;
        Queue<String>q=new LinkedList<>();
        q.add(begin);
        int depth=0,size=0;
        while(!q.isEmpty())
        {
            depth++;
            size=q.size();
            while(size-->0)
            {
                String s=q.poll();
                for(int i=0;i<s.length();i++)
                {
                    for(char c='a';c<='z';c++)
                    {
                        char st[]=s.toCharArray();
                        st[i]=c;
                        String str=new String(st);
                        if(str.equals(end))
                            return depth+1;
                        if(str.equals(s))
                            continue;
                        if(h.contains(str))
                        {
                            q.add(str);
                            h.remove(str);
                        }
                    }
                }
            }
        }
        return 0;
    }
}