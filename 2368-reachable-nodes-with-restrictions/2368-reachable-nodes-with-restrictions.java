class Solution {
    int cnt=0;
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
         dfs(am,vis,0);
        return cnt;
       
    }
    public void dfs( ArrayList<ArrayList<Integer>> am,boolean vis[],int idx)
    {
        vis[idx]=true;
         cnt++;
        for(int x:am.get(idx))
        {
            if( vis[x]==false)
                dfs(am,vis,x);
        }
      
}
}