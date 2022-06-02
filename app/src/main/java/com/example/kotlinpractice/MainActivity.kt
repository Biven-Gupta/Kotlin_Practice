package com.example.kotlinpractice


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ///myFunc(2)
        var time = 0
        binding.apply {

            button.setOnClickListener {
                time += 1
                textView.setTextSize(3, 16F)
                textView.setTextColor(0xff87ceeb.toInt())
                textView.text = time.toString()
                if (time == 1) {
                    Toast.makeText(applicationContext, "Counter Initiated", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            textView.apply {
                setTextColor(0xffff5633.toInt())
                marqueeRepeatLimit = 5

            }
            button.apply {
                text = "Counter"
            }
            button2.apply {
                text = "Clear"
                setBackgroundColor(0xff445633.toInt())
            }
            button2.setOnClickListener {
                time = 0
                textView.setTextSize(3, 22F)
                textView.setTextColor(0xffff5633.toInt())
                textView.text = time.toString()
                Toast.makeText(applicationContext, "Counter Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}