package co.com.gulupagames.interviewexamples

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class InterviewExamples {
    //Simple integer list (Ordered, can repeat)
    private val list = listOf(4, 8, 23, 89, 76, 0, 109, 6567, 34, 76, 95, 73, 63, 15)

    //simple integer set (Not Ordered, cannot repeat)
    private val set = setOf(4, 8, 23, 89, 76, 0, 109, 6567, 34, 76, 95, 73, 63, 15)

    //LinkedHashMap provides a way to order and trace the elements
    private val linkedHashMap = LinkedHashMap<String, String>()

    //HashMap does not support the ordering of the elements
    private val hashMap = HashMap<String, String>()

    //TreeMap will iterate according to the "natural ordering" of the Keys
    private val treeMap = TreeMap<String, String>()

    @Before
    fun setUp() {
        fillHashMaps()
    }

    //Sum all elements
    @Test
    fun listSum() {
        assertEquals(7232, list.sum())
    }

    //multiply 3 times all elements from a list in a new list
    @Test
    fun multiplyListItems() {
        val multiplyList = List(3) { list }.flatten()
        assertEquals(list.size * 3, multiplyList.size)
        println(list)
        println(multiplyList)
    }

    //multiply and sum all items in a list
    @Test
    fun multiplyAndSumAllListItems() {
        var sum = BigInteger.valueOf(1L)
        list.forEach { if (it != 0) sum = BigInteger.valueOf(it.toLong()) * sum }
        assertEquals(BigInteger("60345614035694513433600"), sum)
    }

    //get largest item in a list
    @Test
    fun getLargest() {
        assertEquals(6567, set.max())
    }

    //get largest item in a list
    @Test
    fun getSmallest() {
        assertEquals(0, set.min())
    }

    //get how many times exist a number in a list and in a set
    @Test
    fun finNumberQuantity() {
        val toSearch = 76
        var sumList = 0
        var sumSet = 0
        list.forEach { if (it == toSearch) sumList++ }
        set.forEach { if (it == toSearch) sumSet++ }
        assertEquals(2, sumList)
        assertEquals(1, sumSet)
    }

    @Test
    fun printMaps(){
        println(linkedHashMap)
        println(treeMap)
        println(hashMap)
    }

    private fun fillHashMaps() {
        for (i in 0..99) {
            linkedHashMap["KEY_$i"] = "value $i"
        }
        for (i in 200 downTo 0 step 2) {
            hashMap["KEY_$i"] = "value $i"
        }
        for (i in 0 until 300 step 3) {
            treeMap["KEY_$i"] = "value $i"
        }
    }

}