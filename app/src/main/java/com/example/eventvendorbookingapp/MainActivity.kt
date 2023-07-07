package com.example.eventvendorbookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventvendorbookingapp.databinding.ActivityMainBinding
import com.example.eventvendorbookingapp.databinding.FragmentHomeFragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding
    val database:FirebaseDatabase = FirebaseDatabase.getInstance()
    //val myReference: DatabaseReference = database.reference.child("vendors")
    val dataList = ArrayList<VendorDetails>()
    val bookingList = ArrayList<AppointmentData>()
    lateinit var adapter: Adapter
    lateinit var bookingAdapter: BookingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainBinding.bottomNavigationBar.setOnItemSelectedListener {
            handleBottomNavigation(
                it.itemId
            )
        }
        mainBinding.bottomNavigationBar.selectedItemId = R.id.home

    }

    private fun handleBottomNavigation(
        menuItemId: Int
    ): Boolean = when(menuItemId) {
        R.id.home -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Homefragment() )
                .commit()
            true
        }
        R.id.bookings-> {
            swapFragments(BookingsFragment())
            true
        }
        R.id.profile -> {
            swapFragments(ProfileFragment())
            true
        }
       /* R.id.liked -> {
            swapFragments(RecommendedFragment())
            true
        }*/

        else -> false
    }
    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}