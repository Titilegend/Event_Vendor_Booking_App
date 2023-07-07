package com.example.eventvendorbookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.ActivityVendorprofileDetailBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class VendorProfileDetail : AppCompatActivity(){
    lateinit var vendorProfileDetailBinding: ActivityVendorprofileDetailBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var bookingAdapter: BookingAdapter
    private val dataList = ArrayList<VendorDetails>()
    private val  bookingsList:MutableList<AppointmentData> = mutableListOf()
    private lateinit var vendorDetailsRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vendorProfileDetailBinding = ActivityVendorprofileDetailBinding.inflate(layoutInflater)
        val view = vendorProfileDetailBinding.root
        setContentView(view)




        val name = intent?.getStringExtra("name")
        val location = intent?.getStringExtra("location")
        val phoneNumber = intent?.getStringExtra("phoneNumber")
        val servicesRendered = intent?.getStringExtra("servicesRendered")
        val otherServices = intent?.getStringExtra("otherServices")
        val teamSize = intent?.getStringExtra("teamSize")
        val pricing = intent?.getStringExtra("pricing")
        val website = intent?.getStringExtra("website")
        val socialMediaLink = intent?.getStringExtra("socialMediaLink")
        val description = intent?.getStringExtra("description")
        val accountDetails = intent?.getStringExtra("accountDetails")

        vendorProfileDetailBinding.nameView.text = name
        vendorProfileDetailBinding.locationView.text = location
        vendorProfileDetailBinding.numberView.text = phoneNumber
        vendorProfileDetailBinding.serviceView.text = servicesRendered
        vendorProfileDetailBinding.otherServices.text = otherServices
        vendorProfileDetailBinding.teamSize.text = teamSize
        vendorProfileDetailBinding.priceView.text = pricing
        vendorProfileDetailBinding.websiteView.text = website
        vendorProfileDetailBinding.socialView.text = socialMediaLink
        vendorProfileDetailBinding.descriptionView.text = description
        vendorProfileDetailBinding.account.text = accountDetails

        /*val bookingDialogFragment = BookingDialogFragment.newInstance("name")
        bookingDialogFragment.show(supportFragmentManager, "bookingDialog")*/


        vendorProfileDetailBinding.scheduleAppointmentButton.setOnClickListener {
            val intent = Intent(this@VendorProfileDetail, ClientForm::class.java)
            startActivity(intent)
        }
         // Initialize vendorEntriesRef
       /* vendorProfileDetailBinding.checkBox.setOnClickListener {
            val vendorId =  vendorDetailsRef.push().key.toString()
            val vendorEntriesRef = database.reference.child("vendors")
            val vendorRef = vendorDetailsRef.child(vendorId)

            vendorRef.child("liked").setValue(true)
            val fragment = RecommendedFragment()
            val args = Bundle().apply {
                putString("servicesRendered2",servicesRendered )
                putString("name2", name)
                putString("pricing2",pricing)
                putString("location2",location)
                putString("contactInfo2",phoneNumber)
                putString("otherServices2",otherServices)
                putString("teamSize2",teamSize)
                putString("website2",website)
                putString("socialMedia2",socialMediaLink)
                putString("description2",description)
                putString("accountDetails2",accountDetails)



            }

            fragment.arguments = args
            supportFragmentManager.beginTransaction()
                .add(R.id.cardView2,fragment)
                .addToBackStack(null)
                .commit()
//            val  RecommendData = VendorDetails(name, contactInfo,location,servicesRendered,name,otherServices,teamSize,website,socialMediaLink,pricing,des)
           *//* bookingsRef.child(bookingId).setValue(bookingData)*//*

        }
*/






    }


    /*un onBookingDetailsSubmitted(
        appointmentId: String,
        selectedDate: String,
        selectedTime: String,
        vendorName: String?,
        message: String
    ) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("bookings")
        val bookingId = databaseReference.push().key
        val bookingData = HashMap<String, Any>()
        bookingData["selectedDate"] = selectedDate
        bookingData["selectedTime"] = selectedTime
        vendorName?.let { bookingData["vendorName"] = it } // Only add vendorName if it is not null
        bookingData["message"] = message

        // Save the booking details to the generated child node
        if (bookingId != null) {
            databaseReference.child(bookingId).setValue(bookingData)
        }
    }*/



   /* override fun onBookingDetailsSubmitted(
        appointmentId: String,
        selectedDate: String,
        selectedTime: String,
        vendorName: String?,
        message: String
    ) {
        val appointmentData = vendorName?.let {
            AppointmentData(appointmentId,selectedDate,selectedTime,vendorName,message)
        }
        if (appointmentData != null) {
            bookingsList.add(appointmentData)
        }
        bookingAdapter.notifyDataSetChanged()
    }*/


}



