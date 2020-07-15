public class MaxProfit {

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max=0,min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else if(prices[i]>min){
                 max=Math.max(max,prices[i]-min);
            }
        }
        return max;
    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<=prices[i+1]){
                max=Math.max(max+=prices[i+1]-prices[i],0);
            }
        }
        return max;
    }


    public static void main(String[] args) {

        int[] prices={7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit1(prices));
    }
}
