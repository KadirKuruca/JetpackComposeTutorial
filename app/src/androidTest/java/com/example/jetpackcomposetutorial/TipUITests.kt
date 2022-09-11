package com.example.jetpackcomposetutorial

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip_with_text(){
        composeTestRule.setContent {
            JetpackComposeTutorialTheme {
                TipCalculatorApp()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        composeTestRule.onNodeWithText("Tip amount: $2.00").assertExists()
    }

    @Test
    fun calculate_20_percent_tip_with_tag(){
        composeTestRule.setContent {
            JetpackComposeTutorialTheme {
                TipCalculatorApp()
            }
        }
        composeTestRule.onNodeWithTag("tf_bill_amount").performTextInput("10")
        composeTestRule.onNodeWithTag("tf_tip_amount").performTextInput("20")
        composeTestRule.onNodeWithTag("text_tip_amount_result").assertExists()
    }
}