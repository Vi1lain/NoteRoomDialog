package com.example.noteroomalertdialog

import android.app.Application
import com.example.noteroomalertdialog.data.MainDb


class MyApp:Application() {
    val database by lazy{
        MainDb.createDb(this)
    }
}