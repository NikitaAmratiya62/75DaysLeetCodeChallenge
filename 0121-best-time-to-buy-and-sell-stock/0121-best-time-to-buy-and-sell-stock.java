class Solution {
    public int maxProfit(int[] price) {
        int maxprofit=0,bestbuy=price[0];
        for(int i=0;i<price.length;i++){
            if(price[i]>bestbuy){
                maxprofit=Math.max(maxprofit,price[i]-bestbuy);
            }
            bestbuy=Math.min(bestbuy,price[i]);
        }
        return maxprofit;
    }
}