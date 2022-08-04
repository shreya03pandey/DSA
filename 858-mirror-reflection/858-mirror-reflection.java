class Solution {
    public int mirrorReflection(int p, int q) {
       int tl=2,tr=1,br=0,bl=-1;
        int dist=q;
        return mirror(tl,tr,bl,br,dist,p,q);
    }
    public int mirror(int tl,int tr,int bl,int br,int dist,int p,int q)
    {
        if(dist==p)
            return tr;
        if(dist==0)
            return br;
        if(2*dist<=p)
            return mirror(tr,tl,br,bl,dist+q,p,q);
        else
            return mirror(br,bl,tr,tl,dist+q-p,p,q); 
    }
}