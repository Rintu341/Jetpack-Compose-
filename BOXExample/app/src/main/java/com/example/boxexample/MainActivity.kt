package com.example.boxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boxexample.ui.theme.BOXExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BOXExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Box (
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)

            , contentAlignment = Alignment.Center
        ){
                Box (
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color.Blue)
                        .verticalScroll(rememberScrollState()),
                    contentAlignment = Alignment.Center
                ) { Text(text = "Android", fontSize = 25.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold)}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BOXExampleTheme {
        Greeting()
    }
}