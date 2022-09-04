package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2e6362)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        LogoWithName()
        Spacer(Modifier.weight(1f))
        InformationCard()
    }
}

@Composable
fun LogoWithName() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val logo = painterResource(id = R.drawable.android_logo)
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
        )
        Text(
            text = "Kadir Kuruca",
            fontSize = 40.sp,
            color = Color.White
        )
        Text(
            text = "Senior Android Developer",
            fontWeight = FontWeight.Medium,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun InformationCard() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val phoneLogo = painterResource(id = R.drawable.phone)
            Image(
                painter = phoneLogo,
                contentDescription = "phone_logo",
                modifier = Modifier
                    .padding(start = 40.dp, top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "+90 542 890 29 79",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val phoneLogo = painterResource(id = R.drawable.share)
            Image(
                painter = phoneLogo,
                contentDescription = "share_logo",
                modifier = Modifier
                    .padding(start = 40.dp, top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "@KadirKuruca",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            val phoneLogo = painterResource(id = R.drawable.email)
            Image(
                painter = phoneLogo,
                contentDescription = "email_logo",
                modifier = Modifier
                    .padding(start = 40.dp, top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "kadirkuruca@gmail.com",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticlePreview() {
    JetpackComposeTutorialTheme {
        BusinessCard()
    }
}