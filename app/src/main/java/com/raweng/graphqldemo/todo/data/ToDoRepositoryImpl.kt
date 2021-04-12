package com.raweng.graphqldemo.todo.data

import com.example.LaunchListQuery
import com.raweng.graphqldemo.todo.data.dataSource.ToDoRemoteDataSource
import com.raweng.graphqldemo.utils.Resource
import com.raweng.graphqldemo.utils.SafeApiRequest
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val remoteDataSource: ToDoRemoteDataSource):ToDoRepository,SafeApiRequest() {


    override suspend fun getLaunchQuery(): Resource<LaunchListQuery.Data> {
        return apiRequest { remoteDataSource.getLaunchQuery() }
    }
}