package com.example.a5hw1.presenter

import android.content.Context
import android.widget.Toast
import com.example.a5hw1.MainActivity
import com.example.a5hw1.model.CounterModel
import com.example.a5hw1.model.TextColorModel
import com.example.a5hw1.view.CounterView

class Presenter {
    private lateinit var view: CounterView
    val model = CounterModel()
    val colorModel = TextColorModel()

//    private lateinit var context: Context


    fun increment() {
        model.increment()
        view.updateCounter(model.getCounter())
    }

    fun decrement() {
        model.decrement()
        view.updateCounter(model.getCounter())
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun changeColor() {
        view.changeColor(colorModel.getColor())
    }

//    fun setContext(context: Context) {
//        this.context = context
//    }

    fun toastOrGreenColor() {
        if (model.getCounter() == 10) {
            view.toast()
        } else if (model.getCounter() == 15) {
            view.changeCounterColor(colorModel.getGreenColor())
        }
    }
}