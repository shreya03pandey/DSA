class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
       HashMap<Integer,Integer>m=new HashMap<>();
        for(int x:nums)
            m.put(x,m.getOrDefault(x,0)+1);
        for(Integer x:m.keySet())
            if(m.get(x)>n/2)
                return x;
        return -1;
    }
}