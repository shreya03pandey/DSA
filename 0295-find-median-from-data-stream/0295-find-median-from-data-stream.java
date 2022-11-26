class MedianFinder {
     PriorityQueue<Integer>max;
     PriorityQueue<Integer>min;
    public MedianFinder() {
      max=new PriorityQueue<>(Collections.reverseOrder()); 
      min= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //Inserting
       if(max.size()==0||num<max.peek()) 
           max.add(num);
        else
            min.add(num);
        //Balanced Condition
        if(max.size()==min.size()||max.size()==min.size()+1)
            return;
        //Rebalance
        if(min.size()>max.size())
            max.add(min.poll());
        else 
            min.add(max.poll());
    }
    
    public double findMedian() {
        if(max.size()==min.size())
            return (max.peek()+min.peek())/2.0;
        else
            return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */