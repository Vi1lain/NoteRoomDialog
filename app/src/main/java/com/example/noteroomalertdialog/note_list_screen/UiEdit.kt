package com.example.noteroomalertdialog.note_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteroomalertdialog.data.NoteEntity
import com.example.noteroomalertdialog.data.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun UiEdit(noteViewModel: NoteViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.LightGray
            )
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp),

            ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                TextField(colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White, focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Blue
                ),
                    modifier = Modifier.weight(1f),
                    label = { Text(text = "Title", fontSize = 14.sp) },
                    singleLine = true,
                    value = noteViewModel.checkNoteItem?.title?:"",
                    onValueChange = { textTitle -> noteViewModel.titleState = textTitle })
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.Green

                    )
                }
            }
        }
    }
}