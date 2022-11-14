//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair
{
    String f;
    int s;
    Pair(String first,int sec)
    {
        f=first;
        s=sec;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String>h=new HashSet<>();
        Queue<Pair>q=new LinkedList<>();
        for(String s:wordList)
        h.add(s);
        if(!h.contains(targetWord))
        return 0;
        q.add(new Pair(startWord,1));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            String w=p.f;
            
            for(int i=0;i<w.length();i++)
            {
                for(char j='a';j<='z';j++)
                {
                    char word[]=w.toCharArray();
                    word[i]=j;
                    String st=new String(word);
                    if(h.contains(st))
                    {
                        if(st.equals(targetWord))
                            return p.s+1;
                        q.add(new Pair(st,p.s+1));
                        h.remove(st);
                    }
                }
            }
            
        }
        return 0;
        
    }
}