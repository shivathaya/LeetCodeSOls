class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;     // 1srt buy
        int sell1 = 0;  // profit after 1st sel/\l
        int buy2 = Integer.MIN_VALUE;       // profit remaining after 2nd buy
        int sell2 = 0;  // profit after 2nd sell

        for(int price : prices){
            buy1 = Math.max(buy1, -price);  // best price if bought today
            sell1 = Math.max(sell1, buy1 + price); // profit if sold today
            buy2 = Math.max(buy2, sell1-price); //best price if bouight todat tx2
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}