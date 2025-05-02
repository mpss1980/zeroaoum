package br.com.coupledev.listadehabitos.collections.di

import br.com.coupledev.listadehabitos.collections.domain.GetHabitForTodayUseCase
import br.com.coupledev.listadehabitos.collections.domain.GetHabitForTodayUseCaseImpl
import br.com.coupledev.listadehabitos.collections.domain.ToggleProgressUseCase
import br.com.coupledev.listadehabitos.collections.domain.ToggleProgressUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CollectionsModule {

    @Singleton
    @Binds
    abstract fun providesGetHabitForTodayUseCase(
        impl: GetHabitForTodayUseCaseImpl
    ): GetHabitForTodayUseCase

    @Singleton
    @Binds
    abstract fun providesToggleProgressUseCase(
        impl: ToggleProgressUseCaseImpl
    ): ToggleProgressUseCase
}