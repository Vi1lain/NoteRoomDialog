package com.example.noteroomalertdialog.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteroomalertdialog.MyApp

@Database(entities = [NoteEntity::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        fun createDb(app:MyApp): MainDb =
            Room.databaseBuilder(
                app,
                MainDb::class.java, "room_db.db"
            ).build()
    }

}