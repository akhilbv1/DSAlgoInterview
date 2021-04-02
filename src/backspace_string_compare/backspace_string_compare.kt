package backspace_string_compare

import java.util.*
import kotlin.collections.ArrayList



fun main() {
    val bruteForce = BruteForce()
    val optimal = Solution()
    val S = "ab#c"
    val T = "ad#c"
    println("${bruteForce.backspaceCompare(S, T)}  ${optimal.backspaceCompare(S, T)}")

}

private fun getTestCasesList(): ArrayList<Pair<String, String>> =
    arrayListOf(Pair("ab#c", "ad#c"), Pair("ab##", "c#d#"))


class BruteForce {
    //Time Complexity:-O(n+m)
    //Space Complexity:-O(n+m)
    fun backspaceCompare(S: String, T: String): Boolean {
        val finalFirstInputStack: Stack<String> = Stack()
        val finalSecInputStack: Stack<String> = Stack()
        for (i in 0..S.lastIndex) {//n
            if (S[i].toString() != "#") {
                finalFirstInputStack.push(S[i].toString())
            } else {
                if (!finalFirstInputStack.isEmpty()) finalFirstInputStack.pop()
            }
        }
        for (i in 0..T.lastIndex) {//m
            if (T[i].toString() != "#") {
                finalSecInputStack.push(T[i].toString())
            } else {
                if (!finalSecInputStack.isEmpty()) finalSecInputStack.pop()
            }
        }
        return when {
            finalFirstInputStack.isEmpty() && finalSecInputStack.isEmpty() -> true
            finalFirstInputStack.size != finalSecInputStack.size -> false
            else -> {
                while (!finalFirstInputStack.isEmpty() || !finalSecInputStack.isEmpty()) {
                    val s1 = finalFirstInputStack.pop()
                    val s2 = finalSecInputStack.pop()
                    if (s1 != s2) {
                        return false
                    }
                }
                return true
            }
        }
    }
}

class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        var p1 = S.lastIndex
        var p2 = T.lastIndex
        var skipCounterP1 = 0
        var skipCounterP2 = 0
        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (S[p1].toString() == "#") {
                    skipCounterP1 ++
                    p1--
                } else if (skipCounterP1 > 0) {
                    skipCounterP1--
                    p1--
                } else break
            }
            while (p2 >= 0) {
                if (T[p2].toString() == "#") {
                    skipCounterP2 ++
                    p2--
                } else if (skipCounterP2 > 0) {
                    skipCounterP2--
                    p2--
                } else break
            }
            if (p1 >= 0 && p2 >= 0 && S[p1].toString() != T[p2].toString()) return false
            if ((p1 >= 0) != (p2 >= 0)) return false
            p1--
            p2--
        }
        return true
    }

}
