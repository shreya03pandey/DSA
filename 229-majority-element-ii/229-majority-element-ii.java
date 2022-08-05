class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer>al=new ArrayList<Integer>();
       HashMap<Integer,Integer>m=new HashMap<>();
        for(int x:nums)
            m.put(x,m.getOrDefault(x,0)+1);
        for(Integer x:m.keySet())
            if(m.get(x)>n/3)
                al.add(x);
        return al;
    }
}