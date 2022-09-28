class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty=0,bottle=numBottles,newbottle=0;
        while(bottle>=numExchange)
        {
            newbottle=bottle/numExchange;
            empty+=newbottle*numExchange;
            bottle=newbottle+bottle%numExchange;
        }
        empty+=bottle;
        return empty;
    }
}