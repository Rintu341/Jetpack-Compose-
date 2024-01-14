package com.example.coilcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.coilcompose.ui.theme.CoilComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        CoilImage()
                }
            }
        }
    }
}

@Composable
fun CoilImage()
{
    Box(
        modifier = Modifier
            .wrapContentSize()
            .size(width = 50.dp, height = 50.dp),
        contentAlignment = Alignment.Center,

    ) {
        val penter = "https://th.bing.com/th/id/OIP.mQTt0TOFpWaTXSN0vE3mCgHaGq?rs=1&pid=ImgDetMain"
        AsyncImage(model = penter,
            contentDescription = null
            )

    }
}