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
        assertEquals( true, args.isValid)
        assertEquals(true, args.getBoolean('l'))
        assertEquals(99, args.getInt('p'))
        assertEquals("test", args.getString('d'))
    }

    @Test
    fun emptyArgsResultBoolean() {
        val args = Args("", emptyArray())
        assertEquals( true, args.isValid)
        assertEquals(false, args.getBoolean('l'))
    }

    @Test
    fun emptyArgsResultString() {
        val args = Args("d*", emptyArray())
        assertEquals( true, args.isValid)
        assertEquals("", args.getString('d'))
    }

    @Test
    fun emptyArgsResultInteger() {
        val args = Args("p#", emptyArray())
        assertEquals( true, args.isValid)
        assertEquals(0, args.getInt('p'))
    }

    @Test
    fun testSimpleDoublePresent() {
        val args = Args("x##", arrayOf("-x", "42.3"))
        assertTrue(args.isValid)
        assertEquals(1, args.cardinality())
        assertTrue(args.has('x'))
        assertEquals(42.3, args.getDouble('x'), .001)
    }

    @Test
    fun testInvalidDouble() {
        try {
            Args("x##", arrayOf("-x", "Forty two"))
        } catch (e: ArgsException) {
            assertEquals(ArgsException.ErrorCode.INVALID_DOUBLE, e.errorCode)
            assertEquals('x', e.errorArgumentId)
            assertEquals("Forty two", e.errorMessage())
        }
    }
}