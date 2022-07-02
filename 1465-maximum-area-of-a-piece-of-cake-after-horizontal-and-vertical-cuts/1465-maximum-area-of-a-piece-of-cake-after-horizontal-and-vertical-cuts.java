class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n=horizontalCuts.length;
        int m=verticalCuts.length;
        int maxHori=Math.max(horizontalCuts[0],h-horizontalCuts[n-1]);
        for(int i=1;i<n;i++)
            maxHori=Math.max(maxHori,horizontalCuts[i]-horizontalCuts[i-1]);
         int maxVer=Math.max(verticalCuts[0],w-verticalCuts[m-1]);
        for(int i=1;i<m;i++)
            maxVer=Math.max(maxVer,verticalCuts[i]-verticalCuts[i-1]);
        long ans = 1L * maxHori * maxVer;
        
        return  (int) (ans % 1000000007);
    }
}