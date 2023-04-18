fun main() {
    val prices = listOf(intArrayOf(7,1,5,3,6,4))
    for (price in prices) {
        println("prices: ${price.contentToString()} => profit: ${best_time_to_buy_and_sell_stocks_kevin(price)}")
    }
}

fun best_time_to_buy_and_sell_stocks_kevin(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var profit = 0
    for (price in prices) {
        if (price < minPrice)
            minPrice = price
        else
            profit = maxOf(profit, price - minPrice)
    }
    return profit
}