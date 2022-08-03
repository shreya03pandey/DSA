class MyCalendar {
     TreeMap<Integer,Integer>m;
    public MyCalendar() {
      m=new TreeMap<>(); 
    }
    
    public boolean book(int start, int end) {
        Integer x=m.lowerKey(end);
        if(x==null||m.get(x)<=start)
        {
            m.put(start,end);
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */