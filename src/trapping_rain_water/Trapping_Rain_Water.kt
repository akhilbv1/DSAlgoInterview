package trapping_rain_water

import kotlin.math.min


fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    val input = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    print(bruteForce.trap(input))
    println()
    print(optimal.trap(input))

}

class BruteForce {
    //Time Complexity:-O(n^2)
    //Space Complexity:-O(1)
    fun trap(height: IntArray): Int {
        var answer = 0
        for ((index, i) in height.withIndex()) {
            var currentLeftMax = 0
            var currentRightMax = 0
            for (rightMaxElement in index + 1..height.lastIndex) {
                if (height[rightMaxElement] > currentRightMax) currentRightMax = height[rightMaxElement]
            }
            for (leftMaxElement in index - 1 downTo 0) {
                if (height[leftMaxElement] > currentLeftMax) currentLeftMax = height[leftMaxElement]
            }
            val currentWaterTrap = min(currentLeftMax, currentRightMax) - i
            if (currentWaterTrap > 0) answer += currentWaterTrap
        }
        return answer
    }
}

class Optimal {

    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0
        var answer = 0
        var maxLeft = 0
        var maxRight = 0
        var p1 = 0
        var p2 = height.lastIndex

        while (p1 != p2) {
            if (height[p1] < height[p2] || height[p1] == height[p2]) {
                if (height[p1] < maxLeft) {
                    answer += maxLeft - height[p1]
                } else {
                    maxLeft = height[p1]
                }
                p1++
            } else
                if (height[p2] < height[p1]) {
                    if (height[p2] < maxRight) {
                        answer += maxRight - height[p2]
                    } else {
                        maxRight = height[p2]
                    }
                    p2--
                }
        }
        return answer
    }
}