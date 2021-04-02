package leetcode.guess_number_higher_or_lower

val n = 100000
val pickNum = 90000

fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    println(bruteForce.guessNumber(n))
    println(optimal.guessNumber(n))
}

class BruteForce : GuessGame() {
    //Time Complexity:-O(n)
    //Space Complexity:-O(1)
    override fun guessNumber(num: Int): Int {
        for (i in 0..num) {
            if (guess(i) == 0) {
                return i
            }
        }
        return -1
    }
}

class Optimal : GuessGame() {

    override fun guessNumber(num: Int): Int {
        return findBounds(num)
    }

    private fun findBounds(n: Int): Int {
        var low = 1
        var high = n
        var mid: Int
        while (low <= high) {
            mid = low + (high-low) / 2
            when (guess(mid)) {
                -1 -> {
                    high = mid - 1
                }
                1 -> {
                    low = mid + 1
                }
                0 -> {
                    return mid
                }
            }
        }
        return -1
    }
}

abstract class GuessGame() {
    abstract fun guessNumber(num: Int): Int
    fun guess(num: Int): Int {
        return when {
            pickNum < num -> -1
            pickNum > num -> 1
            else -> 0
        }
    }
}