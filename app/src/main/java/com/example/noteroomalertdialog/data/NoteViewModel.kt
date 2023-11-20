package com.example.noteroomalertdialog.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteroomalertdialog.MyApp
import com.example.noteroomalertdialog.alert_dialog.NoteDialog
import kotlinx.coroutines.launch

class NoteViewModel(val mainDb: MainDb) : ViewModel() {

    var noteList = mainDb.noteDao.getAllNotes()
    var checkNoteItem: NoteEntity? = null
    var titleState by mutableStateOf("")
    var dialogState by  mutableStateOf(false)

    fun insertNote() = viewModelScope.launch {
        if (titleState.isNotEmpty()) {
            val noteItem = checkNoteItem?.copy(title = titleState) ?: NoteEntity(
                title = titleState,
                check = checkNoteItem?.check ?: false
            )
            mainDb.noteDao.insertNote(noteItem)
            checkNoteItem = null
            titleState = ""
        }

    }
    fun deleteNote(noteEntity: NoteEntity) = viewModelScope.launch {
        mainDb.noteDao.deleteNote(noteEntity)
    }

    fun switchCheck (noteEntity: NoteEntity) = viewModelScope.launch {
        mainDb.noteDao.insertNote(noteEntity)
    }

    //@Composable
    //fun openDialog() {
    //    if (dialogState) { } }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as MyApp).database
                return NoteViewModel(database) as T
            }
        }
    }


}