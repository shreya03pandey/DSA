class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty=0,bottle=numBottles,newb=0;
        while(bottle>=numExchange)
        {
            newb=bottle/numExchange;
            empty+=newb*numExchange;
            bottle=newb+bottle%numExchange;
        }
       if(bottle>0) empty+=bottle;
        return empty;
    }
}