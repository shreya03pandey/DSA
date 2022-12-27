//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java
class DisjointSet
{
    int par[];
    int size[];
    DisjointSet(int n)
    {
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++)
        par[i]=i;
    }
    int findPar(int x)
    {
        if(par[x]==x)
        return x;
        else
        return par[x]=findPar(par[x]);
    }
    void unionBySize(int ux,int vx)
    {
        int u=findPar(ux);
        int v=findPar(vx);
        if(u==v)
        return;
        if(size[u]<size[v])
        {
            par[u]=v;
            size[v]+=size[u];
        }
        else
        {
            par[v]=u;
            size[u]+=size[v];
        }
    }
}
class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    
     int n=accounts.size();
     DisjointSet ds=new DisjointSet(n);
     HashMap<String,Integer>m=new HashMap<>();
     for(int i=0;i<n;i++)
     {
         for(int j=1;j<accounts.get(i).size();j++)
         {
             String email=accounts.get(i).get(j);
           if(!m.containsKey(email))
           {
               m.put(email,i);
           }
           else
           {
               ds.unionBySize(i,m.get(email));
           }
         }
     }
     ArrayList<String> arr[]=new ArrayList[n];
     for(int i=0;i<n;i++)
     arr[i]=new ArrayList<String>();
     for(Map.Entry<String,Integer>s:m.entrySet())
     {
         String mail=s.getKey();
         int idx=ds.findPar(s.getValue());
         arr[idx].add(mail);
     }
     List<List<String>> ans=new ArrayList<>();
     for(int i=0;i<n;i++)
     {
         if(arr[i].size()==0) continue;
         Collections.sort(arr[i]);
         ArrayList<String>al=new ArrayList<>();
         al.add(accounts.get(i).get(0));
         for(String st:arr[i])
         al.add(st);
         ans.add(al);
         
     }
     return ans;
  }
}
     