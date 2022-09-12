package com.example.jetpackcomposetutorial.data

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.NavigatorButtons
import com.example.jetpackcomposetutorial.TextDescriptionForImage

data class ImageDescriptionClass(
    val id: Int,
    val title: Int,
    val author: Int,
    val contentDescription: Int,
    val image: Int
)