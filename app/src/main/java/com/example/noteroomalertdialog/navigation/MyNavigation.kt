package com.example.noteroomalertdialog.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteroomalertdialog.data.NoteViewModel
import com.example.noteroomalertdialog.note_list_screen.UiEdit
import com.example.noteroomalertdialog.note_list_screen.UiNoteList


object Routes{
    const val NOTE_LIST = "noteList"
    const val NOTE_EDIT = "noteEDit"
}
@Composable
fun MyNavigation (noteViewModel: NoteViewModel = viewModel(factory = NoteViewModel.factory)){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.NOTE_LIST){
        composable(Routes.NOTE_LIST){ UiNoteList(noteViewModel =noteViewModel,navController = navController)}
        composable(Routes.NOTE_EDIT){ UiEdit(noteViewModel = noteViewModel,navController = navController)}
    }
}