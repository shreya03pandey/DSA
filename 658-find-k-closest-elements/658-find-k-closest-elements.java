class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer>al=new ArrayList<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(arr[i]);
        for(int i=k;i<arr.length;i++)
        {
            if(Math.abs(arr[i]-x)<Math.abs(pq.peek()-x))
            {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty())
            al.add(pq.poll());
        return al;
    }
}