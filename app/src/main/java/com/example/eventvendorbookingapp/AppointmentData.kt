package com.example.eventvendorbookingapp

import android.os.Parcel
import android.os.Parcelable

data class AppointmentData(
    val bookingId:String ="",
    val date:String = "",
    val time: String = "",
    val vendorName:String = "",
    val clientName:String = "",
    val message:String = ""
    )
