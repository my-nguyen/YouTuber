package kevin_naughton

fun main() {
    val prices = listOf(intArrayOf(7,1,5,3,6,4), intArrayOf(1,2,3,4,5), intArrayOf(7,6,4,3,1))
    for (price in prices) {
        println("prices: ${price.contentToString()} => max profit: ${best_time_to_buy_and_sell_stock(price)}")
    }
}

fun best_time_to_buy_and_sell_stock(prices: IntArray): Int {
    var profit = 0
    for (i in 0 until prices.lastIndex) {
        if (prices[i] < prices[i+1])
            profit += prices[i+1] - prices[i]
    }
    return profit
}