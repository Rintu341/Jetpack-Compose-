package com.example.textcomposableexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textcomposableexample.ui.theme.TextComposableExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextComposableExampleTheme {
                Surface (color =  MaterialTheme.colorScheme.background){

                }
            }
        }
    }
}

//For Simple Text
@Composable
fun TextExample1() {
    Text(
        text = stringResource(id = R.string.Android),
        Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .width(200.dp),
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontSize = MaterialTheme.typography.titleLarge.fontSize, // fontSize take size as a number
        fontFamily = FontFamily.Serif,
        color = Color.White,
        overflow = TextOverflow.Ellipsis,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = TextUnit.Unspecified,
        softWrap = true,
        style = TextStyle(
            textMotion = TextMotion.Animated
        )
    )
}
//For Annotated Text
//apply different style for different text/letter in a string
//there you use annotated Text
@Composable
fun TextExample2(str:Char,str2:String)
{
        Text(
            buildAnnotatedString {
                withStyle(
                    style = ParagraphStyle(textAlign = TextAlign.Center)
                ) {
                    //can be apply in whole paragraph
                    withStyle(
                        //apply  can be one character
                        style = SpanStyle(
                            fontSize = 40.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Default
                        )
                    )
                    {
                        append(str)
                    }
                    append(str2)
                }
            },
            fontSize = 20.sp,
        )
}

//visual Text overflow handled
@Composable
fun TextExample3()
{
    Text(text = "Android".repeat(30), maxLines = 2,overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun TextComposableExample()
{
    TextComposableExampleTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            //In modifier remember order of calling function is impotent
            Surface(
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp).background(Color.Gray)
                    .align(Alignment.CenterHorizontally)
            ) {
                TextExample3()
            }
        }
    }
}
