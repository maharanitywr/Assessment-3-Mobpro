package org.d3if3086.assessment3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3086.assessment3.model.Bakso

@Database(entities = [Bakso::class], version = 1, exportSchema = false)
abstract class BaksoDb : RoomDatabase() {

    abstract val dao: BaksoDao

    companion object {

        @Volatile
        private var INSTANCE: BaksoDb? = null

        fun getInstance(context: Context): BaksoDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BaksoDb::class.java,
                        "bakso.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}