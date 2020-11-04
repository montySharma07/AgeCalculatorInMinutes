package com.example.agecalculatorinminutes

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun button(view: View) {
//        Toast.makeText(this,"button is clicked",Toast.LENGTH_LONG).show()
        val calender=Calendar.getInstance()
        val day=calender.get(Calendar.DAY_OF_MONTH)
        val month=calender.get(Calendar.MONTH)
        val year=calender.get(Calendar.YEAR)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            val dateSelected="$i3/${i2+1}/$i"
            text4.text="$dateSelected"
            val sdf=SimpleDateFormat("dd/MM/yy",Locale.ENGLISH)
            val thedate=sdf.parse(dateSelected)
            val dateInMinutes=thedate.time/60000
//            val currentdate=sdf.parse(sdf.format(System.currentTimeMillis()))
//            val currentInMinutes=currentdate.time/60000
            val currentInMinutes=Date().time/60000
            val diff=currentInMinutes-dateInMinutes

            text6.text="$diff"

        },year,month,day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }

}