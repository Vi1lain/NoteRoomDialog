package com.example.noteroomalertdialog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteroomalertdialog.alert_dialog.NoteDialog
import com.example.noteroomalertdialog.data.NoteViewModel
import com.example.noteroomalertdialog.ui.theme.NoteRoomAlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteRoomAlertDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UiNoteList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun UiNoteList() {
    var dialogState by remember { mutableStateOf(false) }
    if (dialogState) {
        NoteDialog(
            confirmButton = { dialogState = false },
            dismissButton = { dialogState = false },
            onDismissRequest = { dialogState = false })
    }
    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text(text = "Add") },
            icon = { Icon(Icons.Default.Create, contentDescription = "add") },
            onClick = {
                dialogState = true

            })
    }) {
        LazyColumn(modifier = Modifier
            .fillMaxSize(), contentPadding = PaddingValues(bottom = 80.dp),
            content = { items(50) { index -> Text(text = "text test - $index") } })
    }
}


