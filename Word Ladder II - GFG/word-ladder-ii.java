//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    HashMap<String,Integer>m=new HashMap<>();
    ArrayList<ArrayList<String>> res=new ArrayList<>();
    String begin;
   public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        begin=startWord;
        HashSet<String>h=new HashSet<>();
        for(String s:wordList)
        h.add(s);
        Queue<String>q=new LinkedList<>();
        q.add(startWord);
        h.remove(startWord);
        m.put(startWord,1);
        while(!q.isEmpty())
        {
            String curr=q.poll();
            if(curr.equals(targetWord))
            break;
            for(int i=0;i<curr.length();i++)
            {
                for(char j='a';j<='z';j++)
                {
                  char ch[]=curr.toCharArray();
                  ch[i]=j;
                  String newWord=new String(ch);
                  if(h.contains(newWord))
                  {
                      q.add(newWord);
                      m.put(newWord,m.get(curr)+1);
                      h.remove(newWord);
                  }
                }
            }
        }
        if(m.containsKey(targetWord))
        {
            ArrayList<String>seq=new ArrayList<>();
            seq.add(targetWord);
            dfs(targetWord,seq);
        }
        return res;
        
    }
    public void dfs(String word,ArrayList<String>seq)
    {
        if(word.equals(begin))
        {
            ArrayList<String>dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            res.add(dup);
            return;
        }
        int l=word.length();
        for(int i=0;i<l;i++)
        {
            for(char j='a';j<='z';j++)
            {
              char ch[]=word.toCharArray();
              ch[i]=j;
              String newWord=new String(ch); 
              if(m.containsKey(newWord)&&(m.get(newWord)+1==m.get(word)))
              {
                seq.add(newWord);
                dfs(newWord,seq);
                seq.remove(newWord);
              }
            }
        }
    }
}
