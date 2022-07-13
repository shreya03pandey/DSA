class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer>s=new Stack<>();
        for(int ast:asteroids)
        {
            if(ast>0)//positive
                s.push(ast);
            else
            {
                while(!s.isEmpty()&&s.peek()>0&&s.peek()<Math.abs(ast))
                 s.pop();  
                if(s.isEmpty()||s.peek()<0)
                    s.push(ast);
                else
                    if(s.peek()==Math.abs(ast))
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