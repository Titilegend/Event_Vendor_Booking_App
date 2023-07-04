package com.example.eventvendorbookingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.FragmentHomeFragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale


class Homefragment : Fragment(R.layout.fragment_home_fragment) {
    private lateinit var homeFragmentBinding: FragmentHomeFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private val dataList = ArrayList<VendorDetails>()
    private lateinit var vendorDetailsRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
        homeFragmentBinding = FragmentHomeFragmentBinding.inflate(inflater, container, false)
        recyclerView = homeFragmentBinding.recyclerView
        adapter = Adapter(dataList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        homeFragmentBinding.recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(context)

        vendorDetailsRef = FirebaseDatabase.getInstance().reference.child("vendors")


        retrieveDataFromDataBase()
        homeFragmentBinding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query:String?):Boolean{
                return false
            }

            override fun onQueryTextChange(newText: String?) :Boolean{
               filterList (newText)
                return true
            }
        })

        return homeFragmentBinding.root
    }


    private fun retrieveDataFromDataBase() {
    vendorDetailsRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            dataList.clear()
            for (entries in snapshot.children) {
                val vendorEntry = entries.getValue(VendorDetails::class.java)
                if (vendorEntry != null) {
                    val fullName = vendorEntry.fullName
                    println("servicesRendered:${vendorEntry.vendorId}")
                    println("fullName:${vendorEntry.vendorId}")
                    println("pricing:${vendorEntry.vendorId}")
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

                adapter = Adapter(dataList)
                //layout design
                homeFragmentBinding.recyclerView.layoutManager =
                    LinearLayoutManager(context)
                homeFragmentBinding.recyclerView.adapter = adapter
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    })

}
    private fun filterList(query: String?) {
        val filteredDataList = ArrayList<VendorDetails>()
        if (!query.isNullOrEmpty()) {
            val lowercaseQuery = query.lowercase(Locale.ROOT)
            for (vendor in dataList) {
                //val formattedQuery = lowercaseQuery.replace("₦","").trim()
                if (vendor.fullName.lowercase(Locale.ROOT).contains(lowercaseQuery) ||
                    vendor.servicesRendered.lowercase(Locale.ROOT).contains(lowercaseQuery)||
                            vendor.pricing.contains(lowercaseQuery)||
                            vendor.location.lowercase(Locale.ROOT).contains(lowercaseQuery)
                ) {
                    filteredDataList.add(vendor)
                }
            }
            adapter.setData(filteredDataList)
        } else {
            adapter.setData(dataList)
        }
    }
}


