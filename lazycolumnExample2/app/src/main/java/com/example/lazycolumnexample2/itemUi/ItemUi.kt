package com.example.lazycolumnexample2.itemUi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Item_ui(name :String,age:Int)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 2.dp,
                color = Color.Red,
                shape = RoundedCornerShape(15.dp)
            )
        ,
        verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceEvenly

    )
    {
        val size:Int = 24
        Text("$age",fontSize = size.sp,)
        Text(name,fontSize = size.sp)


    }
}
@Composable
@Preview (showBackground = true)
fun Item_uiPreview()
{
    Item_ui("Android",24)
}