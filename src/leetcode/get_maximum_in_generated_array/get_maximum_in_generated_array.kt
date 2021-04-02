package leetcode.get_maximum_in_generated_array

import sun.rmi.runtime.Log
import kotlin.math.max


fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    print(bruteForce.getMaximumGenerated(100))
    println()
    print(optimal.getMaximumGenerated(100))
}

class BruteForce {
    //Time Complexity:-O(n/2)
    //Space Complexity:-O(n)
    fun getMaximumGenerated(n: Int): Int {
        if(n==0) return 0
        val genArrayList: IntArray = IntArray(n + 1)
        genArrayList[0] = 0
        genArrayList[1] = 1
        var maxElement = genArrayList[1]
        var index = 1
        var elementsFilled = 2
        while (elementsFilled<n) {
            genArrayList[2 * index] = genArrayList[index]
            genArrayList[(2 * index) + 1] = genArrayList[index] + genArrayList[index + 1]
            index+=1
            elementsFilled+=2
        }
        return if (genArrayList.isNotEmpty())
            genArrayList.max()!!
        else 0
    }
}

//  nums[0] = 0
//  nums[1] = 1
//  nums[(1 * 2) = 2] = nums[1] = 1
//  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
//  nums[(2 * 2) = 4] = nums[2] = 1
//  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
//  nums[(3 * 2) = 6] = nums[3] = 2
//  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
//Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
class Optimal {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) return 0
        val genArrayList: IntArray = IntArray(n + 1)
        val testArrayList: IntArray = IntArray(n + 1)
        var firstCond = 0
        var secondCond = 1
        genArrayList[0] = 0
        genArrayList[1] = 1
        var index = 1
        var elementsFilled = 2
        while (elementsFilled < n) {
            genArrayList[2 * index] = genArrayList[index]
            genArrayList[(2 * index) + 1] = genArrayList[index] + genArrayList[index + 1]
            index += 1
            elementsFilled += 2
        }
        return if (genArrayList.isNotEmpty())
            genArrayList.max()!!
        else 0
    }

}