package com.example.noteroomalertdialog.alert_dialog

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun NoteDialog(onDismissRequest: () -> Unit,
               confirmButton: () -> Unit,
               dismissButton: () -> Unit) {
    AlertDialog(title = {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Добавить запись")
            TextField(value = "Text", onValueChange = {})
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
