package com.example.eventvendorbookingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.ItemBookingBinding
import com.example.eventvendorbookingapp.databinding.VendorListBinding

class BookingAdapter(private val appointmentList:List<AppointmentData>):
RecyclerView.Adapter<BookingAdapter.ViewHolder>(){
    inner class ViewHolder(private val bookingAdapterBinding:ItemBookingBinding):
    RecyclerView.ViewHolder(bookingAdapterBinding.root){
        fun bind(appointmentData: AppointmentData) {
            bookingAdapterBinding.dateTextView.text = appointmentData.date
            bookingAdapterBinding.timeTextView.text = appointmentData.time
            bookingAdapterBinding.nameBookingClientName.text = appointmentData.vendorName
            bookingAdapterBinding.nameBookingVendorName.text = appointmentData.vendorName
            bookingAdapterBinding.messageTextView.text = appointmentData.message
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bookingAdapterBinding = ItemBookingBinding.inflate(inflater, parent, false)
        return ViewHolder(bookingAdapterBinding)
    }

    override fun onBindViewHolder(holder: BookingAdapter.ViewHolder, position: Int) {
        val appointmentData = appointmentList[position]
        holder.bind(appointmentData)
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }/*
    override fun getItemViewType(position: Int): Int {
        return 0
    }*/

}