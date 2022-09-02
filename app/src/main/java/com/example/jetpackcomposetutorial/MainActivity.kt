package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    ComposeQuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantScreen(){
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f, true)){
            ComposableQuadrant(
                title = stringResource(id = R.string.text_composable_text),
                description = stringResource(id = R.string.text_composable_description_text),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f, true)
            )
            ComposableQuadrant(
                title = stringResource(id = R.string.image_composable_text),
                description = stringResource(id = R.string.image_composable_description_text),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f, true)
            )
        }
        Row(modifier = Modifier.weight(1f, true)){
            ComposableQuadrant(
                title = stringResource(id = R.string.row_composable_text),
                description = stringResource(id = R.string.row_composable_description_text),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f, true)
            )
            ComposableQuadrant(
                title = stringResource(id = R.string.column_composable_text),
                description = stringResource(id = R.string.column_composable_description_text),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f, true)
            )
        }
    }
}

@Composable
fun ComposableQuadrant(title: String, description: String, backgroundColor: Color, modifier: Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticlePreview(){
    JetpackComposeTutorialTheme{
        ComposeQuadrantScreen()
    }
}