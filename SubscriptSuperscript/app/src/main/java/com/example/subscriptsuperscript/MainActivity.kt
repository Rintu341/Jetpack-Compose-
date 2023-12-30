package com.example.subscriptsuperscript

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.subscriptsuperscript.ui.theme.SubscriptSuperscriptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubscriptSuperscriptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        Superscript(normalText = "Hello", SuperText = "Android")
                }
            }
        }
    }
}

@Composable
fun Superscript(
    normalText:String,
    SuperText:String,
    normalTextSize:TextUnit  = MaterialTheme.typography.bodyLarge.fontSize,
    SuperTextSize:TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    SuperTextfontWeight:FontWeight = FontWeight.Normal,
    BaseLineShiftForScript:BaselineShift = BaselineShift.Superscript
) {
//    val normalTextSize  = MaterialTheme.typography.bodyLarge.fontSize
//    val SuperTextSize = MaterialTheme.typography.bodySmall.fontSize
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextSize
                )
            )
            {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = SuperTextSize,
                    baselineShift = BaseLineShiftForScript,
                    fontWeight = SuperTextfontWeight
                )
            )
            {
                append(SuperText)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SuperscriptPreview() {
    SubscriptSuperscriptTheme {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Superscript(normalText = "Hello", SuperText = "Android" , BaseLineShiftForScript = BaselineShift.Subscript)
        }
    }
}