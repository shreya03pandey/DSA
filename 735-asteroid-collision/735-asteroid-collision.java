class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>s=new Stack<>();
        for(int x:asteroids)
        {
            if(x>0)
            s.push(x);
            else
            {
                while(!s.isEmpty()&&s.peek()>0&&s.peek()<Math.abs(x))
                    s.pop();
                
                    if(s.isEmpty()||s.peek()<0)
                        s.push(x);
                else
                    if(s.peek()+x==0)
                        s.pop();
            }
        }
        int n=s.size();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--)
            res[i]=s.pop();
        return res;
    }
}