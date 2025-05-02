package br.com.coupledev.listadehabitos.di

import br.com.coupledev.listadehabitos.core.repository.HabitRepository
import br.com.coupledev.listadehabitos.core.repository.HabitRepositoryImpl
import br.com.coupledev.listadehabitos.core.repository.ProgressRepository
import br.com.coupledev.listadehabitos.core.repository.ProgressRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesHabitRepository(impl: HabitRepositoryImpl): HabitRepository

    @Singleton
    @Binds
    abstract fun providesProgressRepository(impl: ProgressRepositoryImpl): ProgressRepository
}