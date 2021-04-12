package com.raweng.graphqldemo.todo.useCase

import com.example.LaunchListQuery
import com.raweng.graphqldemo.todo.data.ToDoRepository
import com.raweng.graphqldemo.utils.Resource
import javax.inject.Inject

class GetQueryListUseCase @Inject constructor(private val repository: ToDoRepository) {

    suspend fun execute(): Resource<LaunchListQuery.Data> = repository.getLaunchQuery()
}