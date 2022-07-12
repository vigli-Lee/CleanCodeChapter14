package com.vigli.deepdive.example.cleancodechapter14

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ArgsUnitTest {

    @Test
    fun validArgs() {
        val args = Args("l,p#,d*", arrayOf("-l", "-p", "99", "-d", "test"))
        assertEquals(args.isValid, true)
        assertEquals(args.getBoolean('l'), true)
        assertEquals(args.getInt('p'), 99)
        assertEquals(args.getString('d'), "test")
    }
}