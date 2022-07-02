public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt=0;  // count of set bit
        while(n!=0){  // iterate until all bits are traversed
			++cnt;
            n=n&(n-1); // change the first set bit from right to 0
        }
        return cnt;
    }
}