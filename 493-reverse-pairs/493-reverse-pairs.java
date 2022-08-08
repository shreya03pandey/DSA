class Solution {
    public int reversePairs(int[] nums) {
     int res=reverse(nums,0,nums.length-1);
        return res;
    }
    public int reverse(int[] nums,int i,int j)
    {
        int res=0;
        if(i<j)
        {
            int mid=(i+j)/2;
            res+=reverse(nums,i,mid);
            res+=reverse(nums,mid+1,j);
            res+=reverseMerge(nums,i,mid,j);
        }
        return res;
    }
    public int reverseMerge(int[] nums,int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int left[]=new int[n1];
        int right[]=new int[n2];
        int res=0;
        for(int i=0;i<n1;i++)
            left[i]=nums[l+i];
        for(int j=0;j<n2;j++)
            right[j]=nums[m+1+j];
        int s=0;
        for(int i=0;i<n1;i++)
        {
           while(s<n2&&left[i]>2*(long)right[s])
               s++;
            res+=s;
        }
        
        int i=0,j=0;
        int k=l;
        while(i<n1&&j<n2)
        {
            if(left[i]<=right[j])
            {
                nums[k++]=left[i++];
            }
            else
            {
               nums[k++]=right[j++];
            }
        }
        while(i<n1) nums[k++]=left[i++];
        while(j<n2) nums[k++]=right[j++];
        return res;
    }
}