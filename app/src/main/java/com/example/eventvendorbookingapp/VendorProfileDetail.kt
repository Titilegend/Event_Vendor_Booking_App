package com.example.eventvendorbookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.ActivityVendorprofileDetailBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class VendorProfileDetail : AppCompatActivity() {
    lateinit var vendorProfileDetailBinding: ActivityVendorprofileDetailBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private val dataList = ArrayList<VendorDetails>()
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



    }
    /*fun retrieveDataFromDataBase() {
        vendorDetailsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (entries in snapshot.children) {
                    val vendorEntry = entries.getValue(VendorDetails::class.java)
                    if (vendorEntry != null) {
                       // println("servicesRendered:${vendorEntry.vendorId}")
                       // println("fullName:${vendorEntry.vendorId}")
                        //println("pricing:${vendorEntry.vendorId}")
                        println("location:${vendorEntry.vendorId}")
                        println("contactInfo:${vendorEntry.vendorId}")
                        println("otherServices:${vendorEntry.vendorId}")
                        println("teamSize:${vendorEntry.vendorId}")
                        println("website:${vendorEntry.vendorId}")
                        println("socialMedia:${vendorEntry.vendorId}")
                        println("description:${vendorEntry.vendorId}")
                        println("accountDetails:${vendorEntry.vendorId}")
                        println("----------------------------")

                        dataList.add(vendorEntry)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }*/
}



