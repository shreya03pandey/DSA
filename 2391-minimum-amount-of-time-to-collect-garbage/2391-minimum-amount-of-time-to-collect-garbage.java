class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
         int metal = 0, glass = 0, paper = 0;
        int n=travel.length;
        int ps[]=new int [n];
        ps[0]=travel[0];
        for(int i=1;i<n;i++)
            ps[i]=ps[i-1]+travel[i];
        int lastM=0,lastG=0,lastP=0;
        for(int idx = 0; idx < garbage.length; idx++){
       
            for(int jdx = 0; jdx < garbage[idx].length(); jdx++)  {
                if(garbage[idx].charAt(jdx) == 'M'){
                    metal++;
                    lastM=idx;
                }
            }
        }
        if(lastM>0)
            metal+=ps[lastM-1];
        
        for(int idx = 0; idx < garbage.length; idx++){
                     
            for(int jdx = 0; jdx < garbage[idx].length(); jdx++){
                if(garbage[idx].charAt(jdx) == 'G'){
                    glass++;
                   lastG=idx;
                }
            }
                
        }
        if(lastG>0)
            glass+=ps[lastG-1];
        for(int idx = 0; idx < garbage.length; idx++){
            for(int jdx = 0; jdx < garbage[idx].length(); jdx++){
                if(garbage[idx].charAt(jdx) == 'P'){
                    paper++;
                  lastP=idx;
                }
            }
                
            
        }
        if(lastP>0)
            paper+=ps[lastP-1];
        return metal+paper+glass;
    }
}