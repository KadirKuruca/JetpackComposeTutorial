package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.data.ImageDescriptionClass
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
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpacePage() {
    val list = prepareList()
    var imageIndex by remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = list[imageIndex].image),
            contentDescription = stringResource(id = list[imageIndex].contentDescription),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(2.dp, color = Color.DarkGray)
                .padding(20.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextDescriptionForImage(
            descriptionTitle = list[imageIndex].title,
            descriptionAuthor = list[imageIndex].author
        )
        Spacer(modifier = Modifier.height(40.dp))
        NavigatorButtons(
            previousOnClick = {
                if(imageIndex > 0)
                    imageIndex--
            },
            nextOnClick = {
                if(imageIndex < 9)
                    imageIndex++
            }
        )
    }
}

@Composable
fun TextDescriptionForImage(descriptionTitle: Int, descriptionAuthor: Int){
    Column(
        modifier = Modifier
            .shadow(2.dp, clip = true)
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(id = descriptionTitle),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = stringResource(id = descriptionAuthor),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "2022",
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun NavigatorButtons(previousOnClick: () -> Unit, nextOnClick: () -> Unit){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = previousOnClick,
            modifier = Modifier.width(120.dp)
        ){
            Text(text = stringResource(R.string.previous_text))
        }
        Button(
            onClick = nextOnClick,
            modifier = Modifier.width(120.dp)
        ){
            Text(text = stringResource(R.string.next_text))
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpacePage()
}

fun prepareList() : ArrayList<ImageDescriptionClass>{
    val imageDescriptionList = ArrayList<ImageDescriptionClass>()
    val imageDescription1 = ImageDescriptionClass(
        id = 1,
        title = R.string.nature_image_title_1,
        author = R.string.nature_image_author_1,
        contentDescription = R.string.nature_image_content_description_1,
        image = R.drawable.nature_1
    )
    val imageDescription2 = ImageDescriptionClass(
        id = 2,
        title = R.string.nature_image_title_2,
        author = R.string.nature_image_author_2,
        contentDescription = R.string.nature_image_content_description_2,
        image = R.drawable.nature_2
    )
    val imageDescription3 = ImageDescriptionClass(
        id = 3,
        title = R.string.nature_image_title_3,
        author = R.string.nature_image_author_3,
        contentDescription = R.string.nature_image_content_description_3,
        image = R.drawable.nature_3
    )
    val imageDescription4 = ImageDescriptionClass(
        id = 4,
        title = R.string.nature_image_title_4,
        author = R.string.nature_image_author_4,
        contentDescription = R.string.nature_image_content_description_4,
        image = R.drawable.nature_4
    )
    val imageDescription5 = ImageDescriptionClass(
        id = 5,
        title = R.string.nature_image_title_5,
        author = R.string.nature_image_author_5,
        contentDescription = R.string.nature_image_content_description_5,
        image = R.drawable.nature_5
    )
    val imageDescription6 = ImageDescriptionClass(
        id = 6,
        title = R.string.nature_image_title_6,
        author = R.string.nature_image_author_6,
        contentDescription = R.string.nature_image_content_description_6,
        image = R.drawable.nature_6
    )
    val imageDescription7 = ImageDescriptionClass(
        id = 7,
        title = R.string.nature_image_title_7,
        author = R.string.nature_image_author_7,
        contentDescription = R.string.nature_image_content_description_7,
        image = R.drawable.nature_7
    )
    val imageDescription8 = ImageDescriptionClass(
        id = 8,
        title = R.string.nature_image_title_8,
        author = R.string.nature_image_author_8,
        contentDescription = R.string.nature_image_content_description_8,
        image = R.drawable.nature_8
    )
    val imageDescription9 = ImageDescriptionClass(
        id = 9,
        title = R.string.nature_image_title_9,
        author = R.string.nature_image_author_9,
        contentDescription = R.string.nature_image_content_description_9,
        image = R.drawable.nature_9
    )
    val imageDescription10 = ImageDescriptionClass(
        id = 10,
        title = R.string.nature_image_title_10,
        author = R.string.nature_image_author_10,
        contentDescription = R.string.nature_image_content_description_10,
        image = R.drawable.nature_10
    )

    imageDescriptionList.add(imageDescription1)
    imageDescriptionList.add(imageDescription2)
    imageDescriptionList.add(imageDescription3)
    imageDescriptionList.add(imageDescription4)
    imageDescriptionList.add(imageDescription5)
    imageDescriptionList.add(imageDescription6)
    imageDescriptionList.add(imageDescription7)
    imageDescriptionList.add(imageDescription8)
    imageDescriptionList.add(imageDescription9)
    imageDescriptionList.add(imageDescription10)
    return imageDescriptionList
}