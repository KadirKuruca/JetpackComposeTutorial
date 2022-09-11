package com.example.jetpackcomposetutorial

import junit.framework.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup(){
        val amount = 10.0
        val tipPercent = 20.0
        val roundUp = false
        val expectedTip = "£2.00"

        val actualTip = calculateTip(amount, tipPercent, roundUp)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculate_20_percent_tip_with_roundup(){
        val amount = 10.0
        val tipPercent = 19.0
        val roundUp = true
        val expectedTip = "£2.00"

        val actualTip = calculateTip(amount, tipPercent, roundUp)
        assertEquals(expectedTip, actualTip)
    }
}