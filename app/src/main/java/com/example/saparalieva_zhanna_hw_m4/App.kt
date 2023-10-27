package com.example.saparalieva_zhanna_hw_m4

import android.app.Application
import androidx.room.Room
import com.example.saparalieva_zhanna_hw_m4.data.local.db.AppDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
         db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var db:AppDatabase
    }
}