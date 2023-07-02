package com.example.eventvendorbookingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.FragmentHomeFragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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
    ): View? {
        homeFragmentBinding = FragmentHomeFragmentBinding.inflate(inflater, container, false)
        recyclerView = homeFragmentBinding.recyclerView
        adapter = Adapter(dataList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        homeFragmentBinding.recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(context)

        vendorDetailsRef = FirebaseDatabase.getInstance().reference.child("vendors")


        retrieveDataFromDataBase()
        return homeFragmentBinding.root
    }

/*

        homeFragmentBinding.searchView.OnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextSubmit(query:String?):Boolean{
                return false
            }

            override fun onQueryTextChange(newText: String?) {
                filterList(newText)
                return true
            }
        })
        return  homeFragmentBinding.root
        }

    private fun filterList(query: String?) {
    if(query!=null){
        filterList = ArrayList<VendorDetails>()
        for(i in VendorDetails){

        }
    }
    }*/


    fun retrieveDataFromDataBase() {
    vendorDetailsRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            dataList.clear()
            for (entries in snapshot.children) {
                val vendorEntry = entries.getValue(VendorDetails::class.java)
                if (vendorEntry != null) {
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
}
