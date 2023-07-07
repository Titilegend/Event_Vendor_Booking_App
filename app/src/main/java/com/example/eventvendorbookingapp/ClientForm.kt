package com.example.eventvendorbookingapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventvendorbookingapp.databinding.ActivityClientFormBinding
import com.google.firebase.database.FirebaseDatabase

class ClientForm : AppCompatActivity() {
    private lateinit var clientFormBinding: ActivityClientFormBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val bookingsRef = database.reference.child("bookings")
    val appointmentList = ArrayList<AppointmentData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clientFormBinding = ActivityClientFormBinding.inflate(layoutInflater)
        val view = clientFormBinding.root
        setContentView(view)




        clientFormBinding.editTextDate.setOnClickListener {
            showDatePicker()
        }

        clientFormBinding.editTextTime.setOnClickListener {
            showTimePicker()
        }

        clientFormBinding.dialogSubmitButton.setOnClickListener {
            val date:String = clientFormBinding.editTextDate.text.toString()
            val time:String = clientFormBinding.editTextTime.text.toString()
            val clientName:String = clientFormBinding.editTextClientName.text.toString()
            val vendorName:String = clientFormBinding.editTextVendorName.text.toString()
            val message:String = clientFormBinding.editTextMessage.text.toString()
            val bookingId: String = bookingsRef.push().key.toString()


            val fragment = BookingsFragment()
            val args = Bundle().apply {
                putString("vendorName", vendorName)
                putString("clientName", clientName)
                putString("date", date)
                putString("time", time)
                putString("message", message)
            }
            val  bookingData = AppointmentData(bookingId,date,time,clientName,vendorName,message)
            bookingsRef.child(bookingId).setValue(bookingData)
            /*val intent = Intent(this@ClientForm, MainActivity::class.java)
            startActivity(intent)*/
            fragment.arguments = args

            supportFragmentManager.beginTransaction()
                .add(R.id.cardBookingsView,fragment)
                .addToBackStack(null)
                .commit()
           /* val intent = Intent(this@ClientForm, MainActivity::class.java)
            startActivity(intent)*/
        }

    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
            val selectedHour = hourOfDay.toString().padStart(2, '0')
            val selectedMinute = minute.toString().padStart(2, '0')
            val selectedTime = "$selectedHour:$selectedMinute"
            clientFormBinding.editTextTime.setText(selectedTime)
        }, hour, minute, false)

        timePickerDialog.show()
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val selectedMonth = month + 1 // Months start from 0
            val selectedDate = "$dayOfMonth/$selectedMonth/$year"
            clientFormBinding.editTextDate.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    fun onLiked(){

    }

    // private fun submitForm() {


    /* val clientName = clientFormBinding.editTextClientName.text.toString()
     val vendorName = clientFormBinding.editTextVendorName.text.toString()
     val message = clientFormBinding.editTextMessage.text.toString()
     val selectedDate = clientFormBinding.editTextDate.text.toString()
     val selectedTime = clientFormBinding.editTextTime.text.toString()

     // Create a data object with the form input
     val appointmentData =
         AppointmentData(selectedDate, selectedTime, clientName, vendorName, message)
     val fragment = BookingsFragment()

     // Get the FragmentManager
     val fragmentManager = supportFragmentManager

     // Start a FragmentTransaction
     val fragmentTransaction = fragmentManager.beginTransaction()

     // Replace the container view with the Fragment
     fragmentTransaction.replace(R.id.constraintBookingLayout, fragment)

     // Add the transaction to the back stack
     fragmentTransaction.addToBackStack(null)

     // Commit the transaction
     fragmentTransaction.commit()*/
}
