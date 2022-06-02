package com.example.kotlinpractice

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class CalculateAgeInMinutes : AppCompatActivity() {
    private var txtShowDate: TextView? = null
    private var ageInMinutes: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_age_in_minutes)

        val btnDatePicker: Button = findViewById(R.id.selectDateButton)
        txtShowDate = findViewById(R.id.showDate)
        ageInMinutes = findViewById(R.id.ageInMinutes)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            { _, sYear, sMonth, sDay ->
                val selectedDate: String?
                if ((sMonth + 1) / 10 != 0 && sDay / 10 != 0) {
                    selectedDate = "$sYear/${sMonth + 1}/$sDay"
                    Toast.makeText(this,
                        "Selected Date! $selectedDate",
                        Toast.LENGTH_SHORT).show()
                } else if ((sMonth + 1) / 10 != 0 && sDay / 10 == 0) {
                    selectedDate = "$sYear/${sMonth + 1}/0$sDay"
                    Toast.makeText(this,
                        "Selected Date! $selectedDate",
                        Toast.LENGTH_SHORT).show()
                } else if ((sMonth + 1) / 10 == 0 && sDay / 10 != 0) {
                    selectedDate = "$sYear/0${sMonth + 1}/$sDay"
                    Toast.makeText(this,
                        "Selected Date! $selectedDate",
                        Toast.LENGTH_SHORT).show()
                } else {
                    selectedDate = "$sYear/0${sMonth + 1}/0$sDay"
                    Toast.makeText(this,
                        "Selected Date! $selectedDate",
                        Toast.LENGTH_SHORT).show()
                }
                txtShowDate?.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val selectDate = sdf.parse(selectedDate)
                selectDate?.let {
                    val selectDateInMinutes = selectDate.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000
                        val diff = currentDateInMinutes - selectDateInMinutes
                        ageInMinutes?.text = diff.toString()
                    }

                }
            },
            year, month, day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 846000
        dpd.show()
    }

    fun oneDigit(view: View) {}
}