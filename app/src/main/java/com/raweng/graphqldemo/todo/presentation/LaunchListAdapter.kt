package com.raweng.graphqldemo.todo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.LaunchListQuery
import com.raweng.graphqldemo.databinding.TodoItemBinding

class LaunchListAdapter(
    private val launches: List<LaunchListQuery.Launch?>
) : RecyclerView.Adapter<LaunchListAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater)

        return ViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(launches[position])
    }


    class ViewHolder(private val view: TodoItemBinding) : RecyclerView.ViewHolder(view.root){
        fun bind(data: LaunchListQuery.Launch?) {
            with(view){
                tvTodo.text=data?.site
            }
        }
    }
}