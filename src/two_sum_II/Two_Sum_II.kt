package two_sum_II


fun main() {
    val bruteForce = BruteForce()
    val optimal = Optimal()

    print(bruteForce.twoSum(intArrayOf(12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997), 542).contentToString())
    println()
    print(optimal.twoSum(intArrayOf(12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997), 542).contentToString())

}

class BruteForce {
    //Time Complexity:-O(n^2)
    //Space Complexity:-O(1)
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val answerArray = IntArray(2)

        for (i in 0..numbers.lastIndex) {
            for (j in i + 1..numbers.lastIndex) {
                if (numbers[i] + numbers[j] == target) {
                    answerArray[0] = i + 1
                    answerArray[1] = j + 1
                    break
                }
            }
        }

        return answerArray
    }
}

class Optimal {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val answerArray = IntArray(2)
        var p1 = 0
        var p2 = numbers.lastIndex

        while (p1 != p2) {
            val sumAtCurrentPass = numbers[p1] + numbers[p2]
            if (sumAtCurrentPass == target) {
                answerArray[0] = p1 + 1
                answerArray[1] = p2 + 1
                break
            } else {
                if (sumAtCurrentPass > target) {
                    p2--
                } else p1++
            }
        }

        return answerArray
    }
    /* fun twoSum(numbers: IntArray, target: Int): IntArray {
         val answerArray = IntArray(2)
         val prevHashMap:HashMap<Int,Int> = hashMapOf()

         for (i in 0..numbers.lastIndex) {
             if(prevHashMap[target-numbers[i]]!=null){
                 answerArray[0] = prevHashMap[target-numbers[i]]!! + 1
                 answerArray[1] = i + 1
                 break
             }
             prevHashMap[numbers[i]] = i
         }

         return answerArray
     }*/
}