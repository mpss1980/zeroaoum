package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.model.ProgressDomain

interface ProgressRepository {

    suspend fun fetch(habitId: String, completedAt: Long): List<ProgressDomain>

    suspend fun add(habitId: String)

    suspend fun delete(id: String)
}