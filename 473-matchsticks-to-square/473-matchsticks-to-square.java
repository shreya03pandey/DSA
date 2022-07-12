class Solution {
    public boolean makesquare(int[] matchsticks) {
        int help[]=new int[4];
        int n=matchsticks.length;
        int sum=0;
        for(int x:matchsticks)
            sum+=x;
        if(sum%4!=0)
            return false;
        int tar=sum/4;
       
        Arrays.sort(matchsticks);
        return dfs( matchsticks,tar,help,n-1);
    }
    public boolean dfs(int[] match,int tar,int[] help,int idx)
    {
        if(idx==-1)
        {
            return (help[0]==help[1])&&(help[1]==help[2])&&(help[2]==help[3]);
        }
        for(int i=0;i<4;i++)
        {
            if(help[i]+match[idx]>tar)
                continue;
            help[i]+=match[idx];
            if(dfs(match,tar,help,idx-1))
                return true;
            help[i]-=match[idx];
        }
        return false;
    }
}