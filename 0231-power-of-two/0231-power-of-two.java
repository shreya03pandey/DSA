class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n<1)
          return false;
        if((n&(n-1))==0)
            return true;
           return false;
    }
}
// n=32  100000
// n=31  011111
//       000000
//     if n is power of 2 how many set bits should be there?->1
//                128 64 32  16 8 4 2 1
//                     1  1  1  1 1 0 0
//         n=124 -> 
//     n=128   -> 10000000 
//           ->00000000->0
        // if(n&(n-1)==0)
        //     return true;
        //    return false;
    