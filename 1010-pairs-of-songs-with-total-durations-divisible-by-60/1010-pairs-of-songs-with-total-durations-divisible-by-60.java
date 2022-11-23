class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n=time.length;
       HashMap<Integer,Integer>m=new HashMap<>();
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt+=m.getOrDefault((60-(time[i]%60))%60,0);
            m.put(time[i]%60,m.getOrDefault(time[i]%60,0)+1);
        }
        return cnt;
    }
}
// time[]={30,20,150,100,40}
// h={30,20,150,100,40}
// cnt=3
// 40%60=40