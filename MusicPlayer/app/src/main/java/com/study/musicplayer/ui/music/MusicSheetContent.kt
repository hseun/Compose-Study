@file:OptIn(ExperimentalMaterial3Api::class)

package com.study.musicplayer.ui.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.study.musicplayer.R

@Composable
fun MusicSheetContent(
    onHidePlayingModal: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onHidePlayingModal) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(text = "IU")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = null)
                    }
                }
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoverImage(
                modifier = Modifier.size(350.dp)
            )
            MusicInformation(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            MusicController(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun _TopAppBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.background(color = Color.Cyan),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.KeyboardArrowDown, contentDescription = null)
        }
        Text(text = "IU")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = null)
        }
    }
}

@Composable
fun CoverImage(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.clip(shape = RoundedCornerShape(12.dp)),
        painter = painterResource(id = R.drawable.img_iu_lovepoem),
        contentDescription = null
    )
}

@Composable
fun MusicInformation(
    modifier: Modifier = Modifier
) {
    var progress by remember {
        mutableStateOf(0f)
    }
    Column(
        modifier = modifier
    ) {
        Text(text = "Blueming")
        Text(text = "IU")
        Slider(value = progress, onValueChange = { newValue ->
            progress = newValue
        })
    }
}

@Composable
fun MusicController(
    modifier: Modifier = Modifier
) {
    var playing by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        }
        IconButton(onClick = { playing = !playing }) {
            Icon(
                imageVector = if (playing) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Filled.PlayArrow
                }, contentDescription = null
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null)
        }
    }
}