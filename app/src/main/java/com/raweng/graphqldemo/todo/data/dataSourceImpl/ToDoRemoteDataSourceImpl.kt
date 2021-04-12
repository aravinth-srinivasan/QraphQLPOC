package com.raweng.graphqldemo.todo.data.dataSourceImpl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.LaunchListQuery
import com.raweng.graphqldemo.todo.data.dataSource.ToDoRemoteDataSource
import javax.inject.Inject

class ToDoRemoteDataSourceImpl @Inject constructor(private val apolloClient: ApolloClient):ToDoRemoteDataSource{

    override suspend fun getLaunchQuery(): Response<LaunchListQuery.Data> =apolloClient.query(LaunchListQuery()).await()

}