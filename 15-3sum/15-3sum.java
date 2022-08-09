class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> alist=new ArrayList<List<Integer>>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<=n-2;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int l=i+1;
            int r=n-1;
            int tar=-nums[i];
            while(l<r)
            {
               int sum=nums[l]+nums[r];
                if(sum==tar)
                {
                    ArrayList<Integer>al=new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[l]);
                    al.add(nums[r]);
                    alist.add(al);
                    l++;
                    r--;
                    while(l<n&&nums[l]==nums[l-1])
                        l++;
                     while(r>=0&&nums[r]==nums[r+1])
                        r--;
                }
                else
                    if(sum<tar)
                        l++;
                else
                    r--;
            }
        }
        return alist;
    }
}