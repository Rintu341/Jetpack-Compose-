package com.example.rowcolumnexample

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rowcolumnexample.ui.theme.RowColumnExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowColumnExampleTheme {
                // A surface container using the 'background' color from the theme
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .width(500.dp)
                            .height(100.dp).
                            background(Color.Gray),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        CustomSurface(weight = 1.0f,MaterialTheme.colorScheme.secondary)
                        CustomSurface(weight = 3.0f,MaterialTheme.colorScheme.primary)
                    }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RowColumnExampleTheme {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .width(500.dp)
                .height(500.dp)
                .background(Color.Gray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            CustomSurface(weight = 1.0f,MaterialTheme.colorScheme.secondary)
            CustomSurface(weight = 3.0f,MaterialTheme.colorScheme.primary)
        }

    }
}
@Composable
fun RowScope.CustomSurface(weight:Float, colors:Color = MaterialTheme.colorScheme.primary) //default parameter
{
        Surface(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .weight(weight),
            color = colors
        ) {}
}
