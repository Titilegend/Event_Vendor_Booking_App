package com.example.eventvendorbookingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.ItemBookingBinding
import com.example.eventvendorbookingapp.databinding.VendorListBinding

class BookingAdapter(private val appointmentList:List<AppointmentData>): RecyclerView.Adapter<BookingAdapter.ViewHolder>(){
    inner class ViewHolder(val bookingAdapterBinding:ItemBookingBinding):
    RecyclerView.ViewHolder(bookingAdapterBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingAdapter.ViewHolder {
        val bookingAdapterBinding = ItemBookingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(bookingAdapterBinding)
    }

    override fun onBindViewHolder(holder: BookingAdapter.ViewHolder, position: Int) {
        holder.bookingAdapterBinding.dateTextView.text = appointmentList[position].date
        holder.bookingAdapterBinding.timeTextView.text = appointmentList[position].time
        holder.bookingAdapterBinding.nameBookingVendorName.text = appointmentList[position].vendorName
        holder.bookingAdapterBinding.nameBookingClientName.text = appointmentList[position].clientName
        holder.bookingAdapterBinding.messageTextView.text = appointmentList[position].message

    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }/*
    override fun getItemViewType(position: Int): Int {
        return 0
    }*/

}