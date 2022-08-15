class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
       ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
          am.add(new ArrayList<Integer>());
        }
        for(int[] x:edges)
        {
            am.get(x[0]).add(x[1]);
            am.get(x[1]).add(x[0]);
        }
        
         boolean vis[]=new boolean[n];
        for(int i:restricted)
            vis[i]=true;
        Queue<Integer>q=new LinkedList<>();
       
        q.add(0);
        
        int ans=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            while(s-->0){
            int curr=q.poll();
                vis[curr]=true;
             ans++;
            for(int x:am.get(curr))
            {
                if(vis[x]==false)
                {
                    
                    q.add(x);
                   
                }
            }
            }
        }
        return ans;
       
    }
}