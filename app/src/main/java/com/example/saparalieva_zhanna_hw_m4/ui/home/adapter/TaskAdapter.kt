package com.example.saparalieva_zhanna_hw_m4.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.saparalieva_zhanna_hw_m4.databinding.ItemTaskBinding
import com.example.saparalieva_zhanna_hw_m4.model.Task

class TaskAdapter : Adapter<TaskAdapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>()

    fun addTask(task:Task){
        list.add(0,task)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
        }
    }
}