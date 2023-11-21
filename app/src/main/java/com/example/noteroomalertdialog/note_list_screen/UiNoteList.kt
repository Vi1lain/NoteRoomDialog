package com.example.noteroomalertdialog.note_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.noteroomalertdialog.alert_dialog.NoteDialog
import com.example.noteroomalertdialog.data.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun UiNoteList(
    navController: NavHostController,
    noteViewModel: NoteViewModel
) {
    val noteList = noteViewModel.noteList.collectAsState(initial = emptyList())
    if (noteViewModel.dialogState) {
        NoteDialog(noteViewModel = noteViewModel,
            confirmButton = {

                noteViewModel.insertNote()
                noteViewModel.dialogState = false
            },
            dismissButton = { noteViewModel.dialogState = false },
            onDismissRequest = { noteViewModel.dialogState = false })
    }
    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text(text = "Add") },
            icon = { Icon(Icons.Default.Create, contentDescription = "add") },
            onClick = {
                noteViewModel.dialogState = true
                noteViewModel.titleState = ""
            })
    }) {
        LazyColumn(modifier = Modifier
            .fillMaxSize(), contentPadding = PaddingValues(bottom = 80.dp),
            content = {
                items(noteList.value) { noteItem ->
                    UiCard(
                        navController = navController,
                        noteViewModel,
                        noteItem,{ note ->
                            noteViewModel.titleState = note.title
                            noteViewModel.checkNoteItem = note
                        },{note->
                            noteViewModel.deleteNote(note)
                        }
                    )
                }
            })
    }
}