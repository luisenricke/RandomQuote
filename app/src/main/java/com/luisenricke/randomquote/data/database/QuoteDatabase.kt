package com.luisenricke.randomquote.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luisenricke.randomquote.data.database.dao.QuoteDao
import com.luisenricke.randomquote.data.database.entities.QuoteEntity

@Database(
    entities = [QuoteEntity::class],
    version = 1
)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

}
