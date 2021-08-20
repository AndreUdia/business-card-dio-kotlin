package com.cabomaldade.businescarddio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
    This class will control the database activities
*/

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun businessDao() : BusinessCardDao

    // this object will create a singleton, return the instance and lock while using
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}