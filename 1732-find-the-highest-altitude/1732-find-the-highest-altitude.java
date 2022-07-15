class Solution {
    public int largestAltitude(int[] gain) {
       int highest = 0;
        int curr = 0;
        for(int diff: gain) {
            curr += diff;
            highest = curr > highest ? curr : highest;
        }
        return highest;  
    }
}