class Solution {
    public int fillCups(int[] amt) {
        int cnt=0;
      PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int x:amt)
            if(x>0)
                pq.add(x);
        while(!pq.isEmpty())
        {
            int f=pq.poll();
            if(pq.size()>=1)
            {
                int s=pq.poll();
                if(s-1>0)
                pq.add(s-1);
            }
            if(f-1>0)
            pq.add(f-1);
            cnt++;
        }
        return cnt;
    }
}