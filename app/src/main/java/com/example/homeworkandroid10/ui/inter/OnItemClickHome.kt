package com.example.homeworkandroid10.ui.inter

import com.example.homeworkandroid10.ui.fragments.models.CreateDataModel

interface OnItemClickHome {
    fun update(taskModel: CreateDataModel)

    fun delete(taskModel: CreateDataModel)
}