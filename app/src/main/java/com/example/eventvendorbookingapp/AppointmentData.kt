package com.example.eventvendorbookingapp

import android.os.Parcel
import android.os.Parcelable

data class AppointmentData(
    val date:String?,
    val time: String?,
    val vendorName:String?,
    val clientName:String?,
    val message:String?,


    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeString(clientName)
        parcel.writeString(vendorName)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppointmentData> {
        override fun createFromParcel(parcel: Parcel): AppointmentData {
            return AppointmentData(parcel)
        }

        override fun newArray(size: Int): Array<AppointmentData?> {
            return arrayOfNulls(size)
        }
    }
}
