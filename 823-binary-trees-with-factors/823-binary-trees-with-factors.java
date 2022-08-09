class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
      HashMap<Integer,Long>m=new HashMap<>();
       m.put(arr[0],1L);
        long sum=1;
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            long res=1;
            for(int j=0;j<i;j++)
            {
              if((arr[i]%arr[j]==0)&&(m.containsKey(arr[i]/arr[j])))
                  res+=(m.get(arr[i]/arr[j])*m.get(arr[j]));
            }
            m.put(arr[i],res);
            sum+=res;
        }
        return (int)(sum%1000000007);
    }
}