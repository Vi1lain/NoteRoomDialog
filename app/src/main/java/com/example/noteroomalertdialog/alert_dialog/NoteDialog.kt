package com.example.noteroomalertdialog.alert_dialog


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.noteroomalertdialog.data.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun NoteDialog(noteViewModel: NoteViewModel,
    onDismissRequest: () -> Unit,
    confirmButton: () -> Unit,
    dismissButton: () -> Unit
) {
    AlertDialog(title = {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Добавить запись")

            TextField(colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                label = { Text(text = "title") },
                modifier = Modifier.fillMaxWidth(),
                value = noteViewModel.titleState,
                onValueChange = {textTitle -> noteViewModel.titleState = textTitle})
        }
    },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(onClick = { confirmButton() }) {
                Text(text = "ok")

            }
        },
        dismissButton = {
            TextButton(onClick = { dismissButton() }) {
                Text(text = "Cansel")

            }
        }
    )

}
