package com.study.musicplayer.data.music

data class PlayList(
    val id: Long,
    val title: String,
    val maker: String
)

val dummyPlayList = listOf(
    PlayList(
        id = 1,
        title = "Love Poem",
        maker = "IU"
    ),
    PlayList(
        id = 2,
        title = "오랜 날 오랜 밤",
        maker = "AKMU"
    ),
    PlayList(
        id = 3,
        title = "Memories",
        maker = "RIIZE"
    ),
    PlayList(
        id = 4,
        title = "Million",
        maker = "WINNER"
    )
)