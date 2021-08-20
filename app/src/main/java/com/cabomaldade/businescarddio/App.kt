package com.cabomaldade.businescarddio

import android.app.Application
import com.cabomaldade.businescarddio.data.AppDatabase
import com.cabomaldade.businescarddio.data.BusinessCardRepository

class App : Application(){
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}