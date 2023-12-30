package com.example.lazycolumnexample2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumnexample2.itemUi.Item_ui
import com.example.lazycolumnexample2.model.person_Data
import com.example.lazycolumnexample2.ui.theme.LazycolumnExample2Theme
import com.example.lazycolumnexample2.ui.theme.back

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazycolumnExample2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        LazyColumnExample()
                }
            }
        }
    }
}

@Composable
fun LazyColumnExample()
{
    val getAllData = person_Data()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2FDD88))
            .padding(16.dp)
            , horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        items(items = getAllData){person ->
            Item_ui(name = person.name, age =person.age )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazycolumnExample2Theme {
        LazyColumnExample()
    }
}