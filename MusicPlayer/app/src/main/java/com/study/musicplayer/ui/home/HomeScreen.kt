package com.study.musicplayer.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.study.musicplayer.data.music.PlayList

@Composable
fun HomeScreen(
    openPlayList: (
        playListId: Long,
        playListTitle: String
    ) -> Unit,
    onShowPlayingModal: () -> Unit
) {

}

class BottomAppBarItem(
    val iconRes: Int,
    val label: String
)

val homeBottomAppBarItem: List<BottomAppBarItem> = listOf(
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_answer,
        label = "홈"
    ),
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_answer,
        label = "검색"
    ),
    BottomAppBarItem(
        iconRes = androidx.core.R.drawable.ic_call_answer,
        label = "라이브러리"
    )
)