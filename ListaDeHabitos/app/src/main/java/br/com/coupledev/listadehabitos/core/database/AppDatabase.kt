package br.com.coupledev.listadehabitos.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.coupledev.listadehabitos.core.database.dao.HabitDao
import br.com.coupledev.listadehabitos.core.database.dao.ProgressDao
import br.com.coupledev.listadehabitos.core.database.entity.Habit
import br.com.coupledev.listadehabitos.core.database.entity.Progress

@Database(entities = [Habit::class, Progress::class], version = 1, exportSchema = false)
@TypeConverters(DaysOfWeekConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao

    abstract fun progressDao(): ProgressDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).build()
                }
            }
            return instance!!
        }

        private const val DATABASE_NAME = "app-database.db"
    }
}
