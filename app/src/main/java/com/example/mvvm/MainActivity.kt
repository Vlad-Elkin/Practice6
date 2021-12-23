package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RandomNumberViewModel
    lateinit var editText:EditText;
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.getRnd)
        editText = findViewById(R.id.rndNum)
        var provider = ViewModelProvider(this)
        viewModel = provider.get(RandomNumberViewModel::class.java)

        observeViewModel()

        initView()
    }

    fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer {
            editText.setText(it.toString())
        })
    }
    fun initView() {
        button.setOnClickListener {
            viewModel.onRandomClicked()
        }
    }
}