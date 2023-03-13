package com.example.incrementamountcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.incrementamountcompose.ui.theme.IncrementAmountComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var clickCount by remember { mutableStateOf(100) }
                // Note to self: the by keyword delegates the property value to clickCount
                // so you would not have to access it. e.g using this ->  var clickCount = remember { mutableStateOf(100) }
                // you get clickCount value like this: clickCount.value
                // but using this -> var clickCount by remember { mutableStateOf(100) }
                // you simply clickCount to get the value

            IncrementAmountComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    Column(modifier = Modifier
                        .background(color = Color.Cyan)
                        .fillMaxHeight()
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "$ ${clickCount}", fontWeight = FontWeight.Bold, fontSize = 20.sp)

                        Spacer(modifier = Modifier.height(60.dp))

                        Box(
                            modifier = Modifier
                                .size(180.dp)
                                .background(Color.White.copy(0.5f), CircleShape)
                                .clickable {
                                    clickCount+=100
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Tap", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    IncrementAmountComposeTheme {
//        Column(modifier = Modifier
//            .background(color = Color.Cyan)
//            .fillMaxHeight()
//            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "$100", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//
//            Spacer(modifier = Modifier.height(60.dp))
//
//            Box(
//                modifier = Modifier
//                    .size(180.dp)
//                    .background(Color.White.copy(0.5f), CircleShape)
//                    .clickable {
//
//                    },
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "Tap", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
//            }
//        }
//    }
}