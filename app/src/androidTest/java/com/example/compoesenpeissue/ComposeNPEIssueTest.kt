/* $Id$ */
package com.example.compoesenpeissue

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

/**
 * Created by Muthuraj on 31/08/21.
 */
class ComposeNPEIssueTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalFoundationApi
    @Test
    fun test() = with(composeTestRule) {
        val textValue = mutableStateOf<TextValue?>(null)

        setContent {
            LazyColumn {
                val text = textValue.value
                if (text != null) {
                    item("item") {
                        Text(text = text.text!!)
                    }
                }
            }
        }
        onNode(hasText("")).assertDoesNotExist()

        textValue.value = TextValue(null)
        onNode(hasText("")).assertDoesNotExist()
    }

    private data class TextValue(val text: String?)
}