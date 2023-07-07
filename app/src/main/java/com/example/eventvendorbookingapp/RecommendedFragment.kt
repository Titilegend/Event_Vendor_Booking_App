package com.example.eventvendorbookingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.FragmentRecommendedBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RecommendedFragment : Fragment() {
    private lateinit var recommendedFragmentBinding: FragmentRecommendedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recomAdapter: RecommendAdapter
    private val recommendList = ArrayList<VendorDetails>()
    private lateinit var recommendRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recommendedFragmentBinding = FragmentRecommendedBinding.inflate(inflater, container, false)
        recyclerView = recommendedFragmentBinding.recyclerViewRecommended
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recomAdapter = RecommendAdapter(recommendList)
        recyclerView.adapter = recomAdapter


        // recommendedFragmentBinding.recyclerViewRecommended.adapter = recomAdapter


        recommendRef = FirebaseDatabase.getInstance().reference.child("vendors")
        val vendorDetailsRef = recommendRef.child("liked")
        /*
        vendorDetailsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val likedChildList = ArrayList<VendorDetails>()

                for (childSnapshot in dataSnapshot.children) {
                    val liked = childSnapshot.getValue(VendorDetails::class.java)

                    if (liked?.liked ==true) { // Check if the "liked" value is not null and is true
                        println("servicesRendered:${liked?.vendorId}")
                        println("fullName:${liked?.vendorId}")
                        println("pricing:${liked?.vendorId}")
                        println("location:${liked?.vendorId}")
                        println("contactInfo:${liked?.vendorId}")
                        println("otherServices:${liked?.vendorId}")
                        println("teamSize:${liked?.vendorId}")
                        println("website:${liked?.vendorId}")
                        println("socialMedia:${liked?.vendorId}")
                        println("description:${liked?.vendorId}")
                        println("accountDetails:${liked?.vendorId}")
                        println("liked:${liked?.vendorId}")
                        println("----------------------------")



                        likedChildList.add(liked!!)
                    }
                }


                processFilteredData(likedChildList)

                //layout design

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })*/

        return recommendedFragmentBinding.root
        /*}
    private fun processFilteredData(likedChildList: ArrayList<VendorDetails>) {
        recomAdapter.setData(likedChildList)
        recomAdapter.notifyDataSetChanged()
        }*/

        /* val adapter = RecommendAdapter(filteredItemList)
        recyclerView.adapter = adapter*/


    }
}


