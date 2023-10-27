package com.example.saparalieva_zhanna_hw_m4.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.saparalieva_zhanna_hw_m4.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDAO
}