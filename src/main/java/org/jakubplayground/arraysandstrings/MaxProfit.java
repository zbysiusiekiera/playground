package org.jakubplayground.arraysandstrings;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int profit = Math.max(prices[1] - prices[0], 0);
        int cheapestPrice = prices[0];

        for (int i = 2; i < prices.length; i++) {
            cheapestPrice = Math.min(cheapestPrice, prices[i - 1]);
            profit = Math.max(profit, prices[i] - cheapestPrice);
        }

        return profit;
    }
}
