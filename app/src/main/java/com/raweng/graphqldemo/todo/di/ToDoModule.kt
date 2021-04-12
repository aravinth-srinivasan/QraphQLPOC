package com.raweng.graphqldemo.todo.di

import com.apollographql.apollo.ApolloClient
import com.raweng.graphqldemo.todo.data.ToDoRepository
import com.raweng.graphqldemo.todo.data.ToDoRepositoryImpl
import com.raweng.graphqldemo.todo.data.dataSource.ToDoRemoteDataSource
import com.raweng.graphqldemo.todo.data.dataSourceImpl.ToDoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ToDoModule {

    @Singleton
    @Provides
    fun provideToDoRepository(remoteDataSource: ToDoRemoteDataSource):ToDoRepository{
        return ToDoRepositoryImpl(remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideToDoRemoteDataSource(appolloClient: ApolloClient):ToDoRemoteDataSource{
        return ToDoRemoteDataSourceImpl(appolloClient)
    }
}