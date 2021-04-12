package com.raweng.graphqldemo.todo.data

import com.example.LaunchListQuery
import com.raweng.graphqldemo.utils.Resource

interface ToDoRepository {

    suspend fun getLaunchQuery():Resource<LaunchListQuery.Data>
}