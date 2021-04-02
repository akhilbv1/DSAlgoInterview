package longest_substring_without_repeating_characters

import kotlin.math.max


fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    println(bruteForce.lengthOfLongestSubstring("aab"))
}

class BruteForce {
    //Time Complexity:-O(n^2)
    //Space Complexity:-O(n)
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubsString = 0
        for (i in 0..s.lastIndex) {
            val currentHashMap: HashMap<String, Boolean> = hashMapOf()
            var currentMax = 0
            for (j in i..s.lastIndex) {
                if (currentHashMap[s[j].toString()] == false || currentHashMap[s[j].toString()] == null) {
                    currentMax++
                    currentHashMap[s[j].toString()] = true
                    longestSubsString = max(currentMax, longestSubsString)
                } else {
                    break
                }
            }
        }
        return longestSubsString
    }
}

class Optimal {
    //SLIDING WINDOW

}