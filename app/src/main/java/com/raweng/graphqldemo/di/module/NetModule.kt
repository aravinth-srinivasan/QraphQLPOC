package com.raweng.graphqldemo.di.module

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com")
            .build()
    }

}