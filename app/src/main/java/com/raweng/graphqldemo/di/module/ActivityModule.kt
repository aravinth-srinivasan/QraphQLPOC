package com.raweng.graphqldemo.di.module

import com.raweng.graphqldemo.todo.presentation.ToDoActivity
import com.raweng.graphqldemo.di.annotation.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeToDoActivity(): ToDoActivity



}