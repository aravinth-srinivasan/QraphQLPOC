package com.raweng.graphqldemo.todo.presentation
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.raweng.graphqldemo.R
import com.raweng.graphqldemo.databinding.ActivityTodoBinding
import com.raweng.graphqldemo.utils.Resource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ToDoActivity : DaggerAppCompatActivity() {

    lateinit var binding:ActivityTodoBinding
    @Inject
    lateinit var viewModel: ToDoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_todo)
        getQueryDataObserver()
    }




    private fun getQueryDataObserver(){
        viewModel.getData().observe(this, Observer{ it ->
            when(it){
                is Resource.Success -> {
                    it.data?.launches?.launches?.let {
                        val adapter =
                            LaunchListAdapter(
                                it
                            )
                        binding.rvList.layoutManager = LinearLayoutManager(this@ToDoActivity)
                        binding.rvList.adapter = adapter
                    }
                }
                is Resource.Loading -> {

                }
                is Resource.Error -> {

                }
            }
        })
    }
}