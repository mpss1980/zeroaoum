package br.com.coupledev.listadehabitos.di

import android.app.Application
import br.com.coupledev.listadehabitos.core.database.AppDatabase
import br.com.coupledev.listadehabitos.core.database.dao.HabitDao
import br.com.coupledev.listadehabitos.core.database.dao.ProgressDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(application: Application): AppDatabase {
        return AppDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun providesHabitDao(database: AppDatabase):HabitDao = database.habitDao()

    @Singleton
    @Provides
    fun providesProgressDao(database: AppDatabase): ProgressDao = database.progressDao()
}

