package com.example.helloworld

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    fun sum(a: Int, b: Int): Int {
        println("a = $a, b = $b")
        return a + b
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, sum(2, 2))
    }
}