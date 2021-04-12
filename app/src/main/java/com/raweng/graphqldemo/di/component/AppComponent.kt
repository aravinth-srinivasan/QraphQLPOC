package com.raweng.graphqldemo.di.component

import android.app.Application
import com.raweng.graphqldemo.app.App
import com.raweng.graphqldemo.di.module.ActivityModule
import com.raweng.graphqldemo.di.module.NetModule
import com.raweng.graphqldemo.todo.di.ToDoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    NetModule::class,
ToDoModule::class
])

interface AppComponent :AndroidInjector<App>{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun bindApplication(application: Application): Builder
        fun build(): AppComponent
    }

}