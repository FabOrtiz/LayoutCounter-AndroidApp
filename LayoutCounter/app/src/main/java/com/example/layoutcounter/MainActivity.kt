package com.example.layoutcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.layoutcounter.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("VALUE_KEY")
        } else {
            counter = 0
        }

        binding.textView.text = counter.toString()
        binding.buttonToast.setOnClickListener {
            showNumber()
        }

        binding.buttonCountUp.setOnClickListener {
            countUp()
        }

        binding.buttonCountDown.setOnClickListener {
            countDown()
        }
    }

    private fun showNumber() {
        Toast.makeText(
            applicationContext,
            "Hello " + binding.textView.text,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun countUp() {
        //val c = binding.textView.text.toInt();
        counter++
        binding.textView.text = counter.toString()
    }

    private fun countDown() {
        counter--
        binding.textView.text = counter.toString()
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("VALUE_KEY", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("VALUE_KEY", 0)
        } else {
            counter = 0
        }

        //set value to UI
        binding.textView.text = counter.toString()


    }
}