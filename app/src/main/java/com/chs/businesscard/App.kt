package com.chs.businesscard

import android.app.Application
import com.chs.businesscard.data.AppDatabase
import com.chs.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}