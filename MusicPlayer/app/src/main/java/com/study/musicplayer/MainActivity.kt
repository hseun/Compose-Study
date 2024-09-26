@file:OptIn(ExperimentalMaterial3Api::class)

package com.study.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.study.musicplayer.ui.home.HomeScreen
import com.study.musicplayer.ui.music.MusicSheetContent
import com.study.musicplayer.ui.playlist.PlayListScreen
import com.study.musicplayer.ui.theme.MusicPlayerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {
                MusicApp()
            }
        }
    }
}

@Composable
fun MusicApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false
        )
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            MusicSheetContent(
                onHidePlayingModal = {
                    scope.launch {
                        scaffoldState.bottomSheetState.hide()
                    }
                }
            )
        },
        sheetDragHandle = null
    ) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    openPlayList = {playListId, playListTitle ->
                        navController.navigate("play_list/$playListId?title=$playListTitle")
                    },
                    onShowPlayingModal = {
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                )
            }
            composable(
                route = "play_list/{play_list_id}?title={play_list_title}",
                arguments = listOf(
                    navArgument(name = "play_list_id") {
                        type = NavType.LongType
                    },
                    navArgument(name = "play_list_title") {
                        type = NavType.StringType
                    }
                )
            ) {backStackEntry ->
                val playListId = backStackEntry.arguments?.getLong("play_list_id")
                    ?: throw IllegalArgumentException()
                val playListTitle = backStackEntry.arguments?.getString("play_list_title")
                    ?: throw IllegalArgumentException()
                PlayListScreen(
                    navigateUp = navController::navigateUp,
                    playListId = playListId,
                    playListTitle = playListTitle
                )
            }
        }
    }
}