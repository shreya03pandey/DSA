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
   public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String>h=new HashSet<>();
        for(String s:wordList)
        h.add(s);
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        Queue<ArrayList<String>>q=new LinkedList<>();
        ArrayList<String>al=new ArrayList<>();
        al.add(startWord);
        q.add(al);
        int level=0;
        ArrayList<String>usedOnLevel=new ArrayList<>();
        usedOnLevel.add(startWord);
        while(!q.isEmpty())
        {
            ArrayList<String>curr=q.poll();
               if(curr.size()>level)//it means we have come to the next level bcoz on the same level
                  //curr.size==level
                  {
                     level++;
                     for(String it:usedOnLevel)
                     h.remove(it);
                     usedOnLevel.clear();
                  }
                  String word=curr.get(curr.size()-1);
                  if(word.equals(targetWord))
                      res.add(curr);
                      for(int i=0;i<word.length();i++)
                      {
                          for(char j='a';j<='z';j++)
                          {
                              char ch[]=word.toCharArray();
                              ch[i]=j;
                              String newWord=new String(ch);
                              if(h.contains(newWord))
                              {
                                  curr.add(newWord);
                                  ArrayList<String>newLevel=new ArrayList<>(curr);
                                  q.add(newLevel);
                                  usedOnLevel.add(newWord);
                                  curr.remove(curr.size()-1);
                              }
                          }
                      }
        }
       return res; 
    }
}
