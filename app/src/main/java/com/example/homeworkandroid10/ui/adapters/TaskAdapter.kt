package com.example.homeworkandroid10.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid10.databinding.ItemTaskBinding
import com.example.homeworkandroid10.ui.fragments.models.CreateDataModel
import com.example.homeworkandroid10.ui.inter.OnItemClickHome

class TaskAdapter(private val list: List<CreateDataModel>, val listener: OnItemClickHome) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(createDataModel: CreateDataModel) {
            binding.tvTittleTask.text = createDataModel.task
            binding.tvDate.text = createDataModel.date
            binding.tvRegular.text = createDataModel.regular
            itemView.setOnClickListener {
                listener.update(createDataModel)
            }
            itemView.setOnLongClickListener {
                listener.delete(createDataModel)
                return@setOnLongClickListener true
            }
        }

    }
}