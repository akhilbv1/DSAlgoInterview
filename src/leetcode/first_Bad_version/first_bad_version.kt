package leetcode.first_Bad_version


val n = 2126753390
val badVersion = 1702766719
fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()
    print(bruteForce.firstBadVersion(n))
    println()
    print(optimal.firstBadVersion(n))
}

class BruteForce : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var badVersion = -1
        for (i in 0..n) {
            if (isBadVersion(i)) {
                badVersion = i
                break
            }
        }
        return badVersion
    }

}

class Optimal : VersionControl() {

    override fun firstBadVersion(n: Int): Int {
        return findBounds(n)
    }

    private fun findBounds(n:Int): Int {
        var low = 1
        var high = n
        var mid: Int
        while (low < high) {
            mid = low+(high - low)/2
            if (isBadVersion(mid)) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }


}

abstract class VersionControl() {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean {
        return version >= badVersion
    }
}