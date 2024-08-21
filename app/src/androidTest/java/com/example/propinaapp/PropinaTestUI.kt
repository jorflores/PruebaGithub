package com.example.propinaapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PropinaTestUI {

    @get: Rule
    val rule = createComposeRule()

    @Test
    fun validaPropina() {
        rule.setContent {
            PropinaApp()
        }

        rule.onNodeWithText("Enter Bill").performTextInput("5000")
        rule.onNodeWithText("Enter Bill").performImeAction()

       // Thread.sleep(2000) // Mantiene la UI abierta por 5 segundos
        rule.onNodeWithContentDescription("Add").performClick()
        rule.onNodeWithContentDescription("Add").performClick()
        rule.onNodeWithContentDescription("Add").performClick()
        //rule.onNodeWithContentDescription("Add").performClick()

        Thread.sleep(5000) // Mantiene la UI abierta por 5 segundos

        rule.onNode(hasText("$1250.0"))
            .assertIsDisplayed()
        Thread.sleep(5000) // Mantiene la UI abierta por 5 segundos

    }


}

