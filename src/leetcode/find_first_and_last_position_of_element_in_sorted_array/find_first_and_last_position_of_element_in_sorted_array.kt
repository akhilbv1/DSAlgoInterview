package leetcode.find_first_and_last_position_of_element_in_sorted_array


fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    val nums = intArrayOf(5, 7, 7, 8, 8, 10)
    val target = 8
    print(bruteForce.searchRange(nums, target).contentToString())
    println()
    print(optimal.searchRange(nums, target).contentToString())
}

class BruteForce {
    //Time Complexity:-O(n)
    //Space Complexity:-O(n)
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val foundIndicesList: ArrayList<Int> = arrayListOf()
        for ((index, element) in nums.withIndex()) {
            if (element == target) {
                foundIndicesList.add(index)
            }
        }
        return if (foundIndicesList.isNotEmpty()) intArrayOf(
            foundIndicesList.first(),
            foundIndicesList.last()
        ) else intArrayOf(-1, -1)
    }
}

class Optimal {
    //Time Complexity:-O(logn)
    //Space Complexity:-O(1)
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val lowerBound = findBounds(nums, target, true)
        val upperBound = findBounds(nums, target, false)
        return intArrayOf(lowerBound, upperBound)
    }

    fun findBounds(arr: IntArray, key: Int, isLower: Boolean): Int {
        var low = 0
        var mid: Int
        var high = arr.lastIndex

        while (low <= high) {
            mid = (low + high) / 2
            if (arr[mid] == key) {
                when (isLower) {
                    true -> {
                        if (mid == low || arr[mid - 1] != key) {
                            return mid
                        }
                        high = mid - 1
                    }
                    else -> {
                        if (mid == high || arr[mid + 1] != key) {
                            return mid
                        }
                        low = mid + 1
                    }
                }

            } else if (arr[mid] > key) {
                high = mid - 1
            } else if (arr[mid] < key) {
                low = mid + 1
            }
        }
        return -1
    }

}