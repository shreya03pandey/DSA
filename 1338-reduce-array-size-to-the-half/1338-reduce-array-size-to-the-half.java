class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length;
       HashMap<Integer,Integer>m=new HashMap<>();
        for(int x:arr)
            m.put(x,m.getOrDefault(x,0)+1);
        int cnt=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer x:m.keySet())
        {
            int val=m.get(x);
            pq.add(val);
        }
        int temp=n;
        while(temp>(n/2))
        {
            int r=pq.poll();
            cnt++;
            temp-=r;
        }
        return cnt;
    }
}