package com.raweng.graphqldemo.todo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.LaunchListQuery
import com.raweng.graphqldemo.todo.useCase.GetQueryListUseCase
import com.raweng.graphqldemo.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ToDoViewModel @Inject constructor(private val useCase: GetQueryListUseCase):ViewModel() {

    val data= MutableLiveData<Resource<LaunchListQuery.Data>>()

    fun getData():LiveData<Resource<LaunchListQuery.Data>>{
        CoroutineScope(Dispatchers.IO).launch {
            data.postValue(useCase.execute())
        }
        return data
    }

}