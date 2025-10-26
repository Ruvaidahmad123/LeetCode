class ATM {
    long store[];
    long denom[]=new long[]{20,50,100,200,500};
    public ATM() {
        store = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            store[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        long ans[]=new long[5];
        int idx=4;
        while(idx>=0 && amount>0){
            long quant= Math.min(amount/denom[idx],store[idx]);
            ans[idx]=quant;
            amount-=quant*denom[idx];
            idx--;
        }
        if(amount>0){
            return new int[]{-1};
        }
        else{
            for(int i=0;i<5;i++){
                store[i]-=ans[i];
            }
            return Arrays.stream(ans).mapToInt(value->(int)value).toArray();
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */