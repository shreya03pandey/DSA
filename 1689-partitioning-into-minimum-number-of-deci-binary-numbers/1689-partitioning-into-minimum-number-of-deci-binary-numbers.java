class Solution {
    public int minPartitions(String n) {
        int max=-1;
       for(int i=0;i<n.length();i++)
       {
          char ch=n.charAt(i);
           if((ch-'0')>max)
            max=ch-'0';   
       }
        return max;
    }
}