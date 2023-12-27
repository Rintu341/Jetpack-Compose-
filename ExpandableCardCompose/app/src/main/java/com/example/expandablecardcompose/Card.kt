package com.example.expandablecardcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ExpandableCard()
{
    var isExpanded by remember{
        mutableStateOf(false)
    }
    val rotateArrow by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f, label = ""
    )

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .animateContentSize(), // This modifier makes the card animate its size changes
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                    Text(
                        text = "Content",
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                        modifier = Modifier.weight(6f),
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                    )
                IconButton(
                    onClick = { isExpanded = !isExpanded},
                    modifier = Modifier.weight(1f)
                        .rotate(rotateArrow)
                        .alpha(0.5f)
                ) {
                    Icon(imageVector = Icons.Filled.KeyboardArrowDown,contentDescription = "ArrowDown",tint = Color.Black)
                }
            }
            if(isExpanded)
            {
                Spacer(modifier = Modifier.height(8.dp))
                Text("I understand that you are looking for information on Expanded Card in" +
                        "Jetpack Compose. Jetpack Compose is a modern UI toolkit for building " +
                        "native Android apps using Kotlin. It provides a more straightforward, " +
                        "more declarative way to build UI components, making it easier for " +
                        "developers to create beautiful, responsive user interfaces",
                    maxLines = 4,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth().padding(4.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground =  true)
fun ExpandableCardPreview()
{
    ExpandableCard()
}