package com.example.a5hw1.view

import android.content.Context
import android.widget.Toast

interface CounterView {
    fun updateCounter(model:Int)
    fun changeColor(color: Int)
    fun changeCounterColor(color: Int)
    fun toast()

}