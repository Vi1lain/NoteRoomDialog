package com.example.noteroomalertdialog.note_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteroomalertdialog.data.NoteEntity
import com.example.noteroomalertdialog.data.NoteViewModel
import com.example.noteroomalertdialog.navigation.Routes


@Composable
fun UiCard(navController: NavController,
           noteViewModel: NoteViewModel,
           noteItem: NoteEntity) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 3.dp, top = 3.dp, end = 3.dp
        )
        .clickable {
            navController.navigate(route = Routes.NOTE_EDIT)
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Checkbox(checked = noteItem.check, onCheckedChange = {check ->
            noteViewModel.switchCheck(noteItem.copy(check=check))})
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .weight(1f),
                text = noteItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            IconButton(onClick = { noteViewModel.deleteNote(noteItem) }) {
                Icon(Icons.Default.Delete, contentDescription = "delete", tint = Color.Red)
            }
        }
    }
}