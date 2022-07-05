class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
      ArrayList<Integer>al=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
          al.add(index[i],nums[i]);
        int res[]=new int[al.size()];
        int k=0;
        for(int i=0;i<al.size();i++)
            res[k++]=al.get(i);
        return res;
    }
}