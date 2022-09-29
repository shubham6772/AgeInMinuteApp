package com.example.ageinminutecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           btnDatePicker.setOnClickListener { view -> clickDatePicker(view) }


    }
    fun clickDatePicker(view: View){
        val mycalander =  Calendar.getInstance()
        val year = mycalander.get(Calendar.YEAR)
        val month = mycalander.get(Calendar.MONTH)
        val day = mycalander.get(Calendar.DAY_OF_MONTH)
          val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->

               val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

               tvSelectDate.setText(selectedDate)

               val sdf = SimpleDateFormat( "dd/MM/yyyy", Locale.ENGLISH)
               val theDate = sdf.parse(selectedDate)
               val selectedDateInMinutes = theDate!!.time/60000
               val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
               val currentDateInMinutes = currentDate!!.time/60000
               val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

               tvSelectDateInMinutes.setText(differenceInMinutes.toString())

           },year, month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }


}