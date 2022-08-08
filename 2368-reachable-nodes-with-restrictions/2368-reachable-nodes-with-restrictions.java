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
        return dfs(am,vis,0);
       
    }
    public int dfs( ArrayList<ArrayList<Integer>> am,boolean vis[],int idx)
    {
        vis[idx]=true;
        int cnt=1;
        for(int x:am.get(idx))
        {
            if( vis[x]==false)
                cnt+=dfs(am,vis,x);
        }
        return cnt;
    }
}