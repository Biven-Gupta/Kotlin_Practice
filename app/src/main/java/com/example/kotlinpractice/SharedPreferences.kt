package com.example.kotlinpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinpractice.databinding.ActivitySharedPreferencesBinding

class SharedPreferences : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("myPrefer", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        binding.apply {
            buttonSave.apply {
                setOnClickListener {
                    val name = editTextTextPersonName.text.toString()
                    val age = editTextTextPersonAge.text.toString().toInt()
                    val isAdult = checkBox.isChecked
                    editor.apply{
                        putString("name",name)
                        putInt("age",age)
                        putBoolean("adult",isAdult)
                        apply()
                    }
                }
            }
            buttonLoad.apply {
                setOnClickListener{
                    val name =sharedPref.getString("name",null)
                    val age=sharedPref.getInt("age",0)
                    val adult =sharedPref.getBoolean("adult",false)
                    editTextTextPersonName.setText(name)
                    editTextTextPersonAge.setText(age.toString())
                    checkBox.isChecked = adult

                }
            }
        }

    }
}