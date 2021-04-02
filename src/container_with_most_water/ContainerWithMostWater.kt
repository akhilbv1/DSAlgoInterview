package container_with_most_water

import kotlin.math.min

fun main() {
    val bruteForce = BruteForce()
    val optimalSolution = OptimalSolution()
    print(bruteForce.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println()
    print(optimalSolution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}


class OptimalSolution {
    fun maxArea(height: IntArray): Int {
        var maxContainer = 0
        var p1 = 0
        var p2 = height.lastIndex
        while (p1 != p2) {
            val maxContainerForCurrentPass = min(height[p1], height[p2]) * (p2 - p1)
            if (maxContainerForCurrentPass > maxContainer)
                maxContainer = maxContainerForCurrentPass

            if (height[p1] < height[p2])
                p1++ else p2--
        }


        return maxContainer
    }
}


class BruteForce {
    //Brute force
    //Time Complexity:-O(n^2)
    //Space Complexity:-O(n)
    fun maxArea(height: IntArray): Int {
        var maxContainer = 0
        for ((index, i) in height.withIndex()) {
            var maxForCurrentIndex = 0
            for ((index1, j) in height.withIndex()) {
                val maxForCurrentPass = min(i, j) * (index1 - index)
                if (maxForCurrentPass > maxForCurrentIndex) maxForCurrentIndex = maxForCurrentPass
            }
            if (maxForCurrentIndex > maxContainer) maxContainer = maxForCurrentIndex
        }
        return maxContainer
    }
}
