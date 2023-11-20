package com.example.noteroomalertdialog.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val title:String,
    var check:Boolean
)
