fun main() {
    val prices = listOf(intArrayOf(7,1,5,3,6,4), intArrayOf(7,6,4,3,1))
    for (price in prices) {
        println("prices: ${price.contentToString()} => profit: ${best_time_to_buy_and_sell_stocks_nick(price)}")
    }
}

fun best_time_to_buy_and_sell_stocks_nick(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var profit = 0
    for (price in prices) {
        if (price < minPrice)
            minPrice = price
        else if (price - minPrice > profit)
            profit = price - minPrice
    }
    return profit
}