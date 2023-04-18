package nick_white

import java.util.*

fun main() {
    val asteroids = listOf(intArrayOf(5,10,-5), intArrayOf(8,-8), intArrayOf(10,2,-5), intArrayOf(-2,-1,1,2))
    for (asteroid in asteroids) {
        println("asteroids: ${asteroid.contentToString()} => post collision: ${asteroid_collision_nick(asteroid).contentToString()}")
    }
}

fun asteroid_collision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    for (asteroid in asteroids) {
        if (asteroid > 0)
            stack.push(asteroid)
        else {
            if (stack.isEmpty())
                stack.push(asteroid)
            else {
                var current = 0
                while (stack.isNotEmpty()) {
                    if (stack.peek() < 0) {
                        stack.push(asteroid)
                        break
                    }
                    if (stack.peek() == -asteroid) {
                        stack.pop()
                        current = 0
                        break
                    }
                    if (stack.peek() > -asteroid) {
                        current = 0
                        break
                    }
                    stack.pop()
                    current = asteroid
                }
                if (current != 0)
                    stack.push(current)
            }
        }
    }
    return stack.toIntArray()
}

fun asteroid_collision_nick(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    for (asteroid in asteroids) {
        if (stack.isEmpty() || asteroid > 0)
            stack.push(asteroid)
        else {
            while (true) {
                val top = stack.peek()
                if (top < 0) {
                    stack.push(asteroid)
                    break
                } else {
                    if (top == -asteroid) {
                        stack.pop()
                        break
                    }
                    if (top > -asteroid)
                        break
                    stack.pop()
                    if (stack.isEmpty()) {
                        stack.push(asteroid)
                        break
                    }
                }
            }
        }
    }
    return stack.toIntArray()
}
