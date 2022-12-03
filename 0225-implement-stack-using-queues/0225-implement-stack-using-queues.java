class MyStack {
      Queue<Integer>q;
    public MyStack() {
       q=new LinkedList<>(); 
    }
    
    public void push(int x) {
      q.add(x);
        int s=q.size();
           for(int i=0;i<s-1;i++)
            q.add(q.poll());
    }
    
    public int pop() {
       return q.poll(); 
    }
    
    public int top() {
       return q.peek(); 
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */                          
// ops=push(6),push(8),push(10),peek(),pop(),pop(),push(18),pop()
// q={6}

// ->10 10 8 18