package com.example.noteroomalertdialog.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.noteroomalertdialog.alert_dialog.NoteDialog

class NoteViewModel() : ViewModel() {

    var dialogState by mutableStateOf(false)

    @Composable
    fun openDialog() {
        if (dialogState) {
            NoteDialog(
                onDismissRequest = { dialogState = false },
                dismissButton = { dialogState = false },
                confirmButton = { dialogState = false })
        }
    }
}