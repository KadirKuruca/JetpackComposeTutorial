package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeScreen() {
    var currentStep by remember { mutableStateOf(1) }
    var randomSqueezeCount by remember { mutableStateOf(0) }
    when (currentStep) {
        1 -> {
            LemonWithImageAndText(
                R.string.tap_to_select_lemon_text,
                R.drawable.lemon_tree,
                R.string.lemon_tree_content_description_text,
                onImageClick = {
                    currentStep = 2
                    randomSqueezeCount = (2..6).random()
                }
            )
        }
        2 -> {
            LemonWithImageAndText(
                R.string.tap_to_squeeze_lemon_text,
                R.drawable.lemon_squeeze,
                R.string.lemon_content_description_text,
                onImageClick = {
                    randomSqueezeCount--
                    if(randomSqueezeCount == 0)
                        currentStep = 3
                }
            )
        }
        3 -> {
            LemonWithImageAndText(
                R.string.tap_lemon_to_drink_text,
                R.drawable.lemon_drink,
                R.string.glass_of_lemonade_content_description_text,
                onImageClick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            LemonWithImageAndText(
                R.string.tap_glass_to_start_again_text,
                R.drawable.lemon_restart,
                R.string.empty_glass_content_description_text,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun LemonWithImageAndText(
    textId: Int,
    imageId: Int,
    contentDescIt: Int,
    onImageClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textId),
            fontSize = 16.sp
        )
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = contentDescIt),
            modifier = Modifier
                .padding(top = 16.dp)
                .border(1.dp, Color(0xFF69cdd8), CutCornerShape(4.dp))
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeScreen()
}