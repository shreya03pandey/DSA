class Solution {
    public int countStudents(int[] students, int[] san) {
        Queue<Integer>q=new LinkedList<Integer>();
        for(int x:students)
            q.add(x);
        int i=0;
        int cnt=0;
        while(!q.isEmpty()&&cnt!=q.size())
        {
            if(q.peek()==san[i])
            {
                i++;
                q.poll();
                cnt=0;
            }
            else
            {
                q.add(q.poll());
                cnt++;
            }
        }
        return cnt;
    }
}