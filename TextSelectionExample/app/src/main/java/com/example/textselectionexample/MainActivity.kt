package com.example.textselectionexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textselectionexample.ui.theme.TextSelectionExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextSelectionExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextSelection()
                }
            }
        }
    }
}

@Composable
fun TextSelection() {
    SelectionContainer { //allow to copy ui element like text
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {

                Text(text = "Android")
                DisableSelection {
                    Text(text = "Android") // this text is disable to copy
                }
                Text(text = "Android")
            }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextSelectionExampleTheme {
        TextSelection()
    }
}