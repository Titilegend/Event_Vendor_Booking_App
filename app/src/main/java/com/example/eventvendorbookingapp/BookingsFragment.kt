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
    private lateinit var vendorName: String
    private lateinit var clientName: String
    private lateinit var message: String
    private lateinit var date:String
    private  lateinit var time:String

   companion object {
        private const val ARG_VENDOR_NAME = "vendorName"
        private const val ARG_CLIENT_NAME = "clientName"
        private const val ARG_MESSAGE = "message"
        private const val ARG_DATE = "date"
        private const val ARG_TIME = "time"


        fun newInstance(vendorName: String, clientName: String, date:String,time:String,message:String): BookingsFragment {
            val fragment = BookingsFragment()
            val args = Bundle().apply {
                putString(ARG_VENDOR_NAME, vendorName)
                putString(ARG_CLIENT_NAME, clientName)
                putString(ARG_MESSAGE, message)
                putString(ARG_DATE, date)
                putString(ARG_TIME, time)

            }
            fragment.arguments = args
            return fragment
        }
    }
    //private val appointmentList = ArrayList<AppointmentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bookingsFragmentBinding = FragmentBookingsFragmentBinding.inflate(inflater, container, false)
        //bookingRecycleView = bookingsFragmentBinding.recyclerViewBookings
        vendorName = arguments?.getString(ARG_VENDOR_NAME, "")?: " "
        clientName = arguments?.getString(ARG_CLIENT_NAME, "")?: ""
        message = arguments?.getString(ARG_MESSAGE, "")?:""
        date = arguments?.getString(ARG_DATE,"")?:""
        time = arguments?.getString(ARG_TIME,"")?:""

        // Use the form data to populate the RecyclerView
         val list = ArrayList<AppointmentData>()

        val bookingList = AppointmentData(vendorName,time,vendorName,clientName,message)
        list.add(bookingList)
        val adapter = BookingAdapter(list) // Replace with your RecyclerView adapter

        bookingsFragmentBinding.recyclerViewBookings.layoutManager = LinearLayoutManager(context)
        bookingsFragmentBinding.recyclerViewBookings.adapter = adapter
        return bookingsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*bookingsFragmentBinding.recyclerViewBookings.layoutManager =
            LinearLayoutManager(requireContext())*/
        //bookingAdapter = BookingAdapter(appointmentList)
       // bookingsFragmentBinding.recyclerViewBookings.adapter = bookingAdapter




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









