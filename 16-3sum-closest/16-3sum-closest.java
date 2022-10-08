class Solution {
    public int threeSumClosest(int[] nums, int target) {
     Arrays.sort(nums);
        int n = nums.length;
        int mindiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i = 0; i < n-2; i++){
            int j = i+1, k = n-1;
            
            while(j < k){
                int a = nums[i], b = nums[j], c = nums[k];
                int sum = a + b + c;
                int diff = Math.abs(sum - target);
                if(diff < mindiff){
                    mindiff = diff;
                    closestSum = sum;
                }
                if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return closestSum;
    }
   
    
}