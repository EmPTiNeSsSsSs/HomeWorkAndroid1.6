package com.example.homeworkandroid10.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homeworkandroid10.ui.fragments.models.CreateDataModel

@Database(entities = [CreateDataModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}