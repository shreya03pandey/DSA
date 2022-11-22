class MinStack {
     Stack<Integer>st;
     Stack<Integer>min;
    public MinStack() {
       st=new Stack<>();
       min=new Stack<>();
    }
    
    public void push(int val) {
       if(st.isEmpty()||min.peek()>=val)
           min.push(val);

        st.push(val);
    }
    
    public void pop() {
       if(st.peek().equals(min.peek())) min.pop();        
            st.pop();
        
    }
    
    public int top() {
       return st.peek(); 
    }
    
    public int getMin() {
       return min.peek(); 
    }
}

// st={0,1,0}
// min={0,}
// 0
// st={-2,}
// min={-2}
// getmin=

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */