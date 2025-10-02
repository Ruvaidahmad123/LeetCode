class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum=0;
        sum+=numBottles;
        int emptybot=numBottles;
        numBottles=0;
        while(emptybot>=numExchange || numBottles>0){
            // System.out.println(sum+" "+emptybot+" "+numExchange+" "+numBottles);
            int val=0;
            if(emptybot>0){
                val=(numExchange-emptybot);
            }
            if(emptybot>=numExchange){
                numBottles++;
                emptybot-=numExchange;
                numExchange++;
            }
            else if((val+emptybot)==numExchange && (val==numBottles)){
                sum+=numBottles;
                emptybot+=numBottles;
                numBottles=0;
            }
            else{
                sum+=1;
                numBottles--;
            }
        }
        // sum+=numBottles;
        return sum;
    }
}