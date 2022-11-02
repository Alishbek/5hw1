package com.example.a5hw1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a5hw1.databinding.ActivityMainBinding
import com.example.a5hw1.presenter.Presenter
import com.example.a5hw1.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
//        presenter.setContext(this)
        onClick()
        textColor()
    }

    private fun onClick() {
        binding.btnIncrement.setOnClickListener {
            presenter.increment()
            presenter.toastOrGreenColor()
        }
        binding.btnDecrement.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun updateCounter(model: Int) {
        binding.tvCounter.text = model.toString()
    }

    override fun changeColor(color: Int) {
        binding.tvHello.setTextColor(color)
    }

    override fun changeCounterColor(color: Int) {
        binding.tvCounter.setTextColor(color)
    }

    override fun toast() {
        Toast.makeText(this, "Поздравляем! :)", Toast.LENGTH_SHORT).show()
    }

    private fun textColor() {
        binding.btnChange.setOnClickListener {
            presenter.changeColor()
        }
    }

}