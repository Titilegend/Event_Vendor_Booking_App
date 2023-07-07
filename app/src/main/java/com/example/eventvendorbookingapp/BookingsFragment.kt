package com.example.eventvendorbookingapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.FragmentBookingsFragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BookingsFragment : Fragment(R.layout.fragment_bookings_fragment) {
    private lateinit var bookingsFragmentBinding: FragmentBookingsFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BookingAdapter
    private val bookingList = ArrayList<AppointmentData>()
    private lateinit var bookingsRef: DatabaseReference


    //private val appointmentList = ArrayList<AppointmentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bookingsFragmentBinding = FragmentBookingsFragmentBinding.inflate(inflater, container, false)
        recyclerView = bookingsFragmentBinding.recyclerViewBookings
        adapter = BookingAdapter(bookingList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        bookingsFragmentBinding.recyclerViewBookings.adapter = adapter
        bookingsRef = FirebaseDatabase.getInstance().reference.child("bookings")
        retrieveDataFromDataBase()

        return bookingsFragmentBinding.root
    }

    private fun retrieveDataFromDataBase() {
        bookingsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                bookingList.clear()
                for (entries in snapshot.children) {
                    val bookingEntry = entries.getValue(AppointmentData::class.java)
                    if (bookingEntry != null) {
                        println("date:${bookingEntry.bookingId}")
                        println("time:${bookingEntry.bookingId}")
                        println("vendorName:${bookingEntry.bookingId}")
                        println("clientName:${bookingEntry.bookingId}")
                        println("message:${bookingEntry.bookingId}")
                        println("----------------------------")

                        bookingList.add(bookingEntry)
                    }

                    adapter = BookingAdapter(bookingList)
                    //layout design
                    bookingsFragmentBinding.recyclerViewBookings.layoutManager =
                        LinearLayoutManager(context)
                    bookingsFragmentBinding.recyclerViewBookings.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

 /*   companion object {
        private const val FORM_DATA_KEY = "form_data_key"

        fun newInstance(formData: AppointmentData): BookingsFragment {
            val fragment = BookingsFragment()
            val args = Bundle().apply {
                putParcelable(FORM_DATA_KEY, formData)
            }
            fragment.arguments = args
            return fragment
        }

    }*/
}


    /* private fun retrieveDataFromDataBase() {
        vendorDetailsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (entries in snapshot.children) {
                    val vendorEntry = entries.getValue(VendorDetails::class.java)
                    if (vendorEntry != null) {
                        val fullName = vendorEntry.fullName
                        println("fullName:${vendorEntry.vendorId}")
                        println("----------------------------")

                        dataList.add(vendorEntry)
                    }

            override fun onCancelled(error: DatabaseError) {

            }



    }
        })*/









