package com.raweng.graphqldemo.todo.data.dataSource

import com.apollographql.apollo.api.Response
import com.example.LaunchListQuery

interface ToDoRemoteDataSource {
    suspend fun getLaunchQuery(): Response<LaunchListQuery.Data>
}