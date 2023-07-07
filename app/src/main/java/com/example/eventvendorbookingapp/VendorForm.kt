package com.example.eventvendorbookingapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.eventvendorbookingapp.databinding.ActivityVendorFormBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class VendorForm : AppCompatActivity() {
    lateinit var vendorFormBindng: ActivityVendorFormBinding
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val vendorEnteriesRef = database.reference.child("vendors")


    val dataList = ArrayList<VendorDetails>()
    lateinit var adapter: Adapter

    //val locationOptions: Array<String> = resources.getStringArray(R.array.nigeria_states)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vendorFormBindng = ActivityVendorFormBinding.inflate(layoutInflater)
        val view = vendorFormBindng.root
        setContentView(view)


//      Validate Website URL
        val websiteUrl = vendorFormBindng.websiteEditText.text.toString()
        if (!websiteUrl.isEmpty() && !Patterns.WEB_URL.matcher(websiteUrl).matches()) {
            // Invalid website URL
            vendorFormBindng.websiteEditText.error = "Invalid website URL"
        }

// Validate Social Media Link
        val socialMediaLink = vendorFormBindng.socialMediaEditText.text.toString()
        if (!socialMediaLink.isEmpty() && !Patterns.WEB_URL.matcher(socialMediaLink).matches()) {
            // Invalid social media link
            vendorFormBindng.socialMediaEditText.error = "Invalid social media link"
        }
        val getContent =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                // Handle the selected image URI
                if (uri != null) {
                    vendorFormBindng.imageList1.setImageURI(uri)
                }
            }
        //  vendorFormBindng.imageList1.setOnClickListener {
        // Open the image picker dialog
        //    getContent.launch("image/*")
        // }


        val locationList = resources.getStringArray(R.array.nigeria_states)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, locationList)
        vendorFormBindng.locationList.setAdapter(arrayAdapter)

        val priceList = resources.getStringArray(R.array.price_list)
        val priceArrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, priceList)
        vendorFormBindng.pricingAutoComplete.setAdapter(priceArrayAdapter)

        val servicesList = resources.getStringArray(R.array.services_rendered)
        val servicesArrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, servicesList)
        vendorFormBindng.servicesRenderedList.setAdapter(servicesArrayAdapter)

        val teamSizeList = resources.getStringArray(R.array.team_size_list)
        val teamSizeArrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,teamSizeList)
        vendorFormBindng.teamSizeEditText.setAdapter(teamSizeArrayAdapter)

        vendorFormBindng.submitButton.setOnClickListener {
            //val selectedImage = vendorFormBindng.imageList1.setImageResource(R.drawable.profile_image_xml)
            val category: String = vendorFormBindng.servicesRenderedList.text.toString()
            val name: String = vendorFormBindng.fullNameEditText.text.toString()
            val priceRange: String = vendorFormBindng.pricingAutoComplete.text.toString()
            val location:String = vendorFormBindng.locationList.text.toString()
            val phoneNumber:String = vendorFormBindng.phoneNumberEditText.text.toString()
            val otherServices:String = vendorFormBindng.etOtherServices.text.toString()
            val teamSize:String = vendorFormBindng.teamSizeEditText.text.toString()
            val website:String = vendorFormBindng.websiteEditText.text.toString()
            val socialMediaLink:String = vendorFormBindng.socialMediaEditText.text.toString()
            val description:String = vendorFormBindng.descriptionEditText.text.toString()
            val accountDetails:String = vendorFormBindng.accountDetailsEditText.text.toString()




            if (name.isEmpty()) {
                vendorFormBindng.fullNameEditText.error = "Please enter a name"

                return@setOnClickListener
            }


            if (phoneNumber.isEmpty()) {
                vendorFormBindng.phoneNumberEditText.error = "Please enter a phone number"
                return@setOnClickListener
            }

            if (!isValidPhoneNumber(phoneNumber)) {
                vendorFormBindng.phoneNumberEditText.error = "Please enter a valid phone number"
                return@setOnClickListener
            }

            if (website.isNotEmpty() && !isValidWebsite(website)) {
                vendorFormBindng.websiteEditText.error = "Please enter a valid website URL"
                return@setOnClickListener
            }
           // !isValidSocialMedia(socialMediaLink)
            if (socialMediaLink.isEmpty()) {
                vendorFormBindng.socialMediaEditText.error = "Please enter a valid social media URL"
                return@setOnClickListener
            }

            val vendorId: String = vendorEnteriesRef.push().key.toString()

            val formData = VendorDetails(vendorId,phoneNumber,location,category,name,otherServices,teamSize,website,socialMediaLink,priceRange,description,accountDetails,liked = false)
            vendorEnteriesRef.child(vendorId).setValue(formData)

            val intent = Intent(this@VendorForm, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val cleanedPhoneNumber = phoneNumber.replace("\\D+".toRegex(), "")
        return cleanedPhoneNumber.length == 13 && cleanedPhoneNumber.startsWith("234")
    }


    // Website URL validation function
    fun isValidWebsite(website: String): Boolean {
        val websiteRegex = Regex("^(http(s)?://)?[\\w.-]+\\.[a-zA-Z]{2,6}(/[\\w.-]*)*/?")
        return website.matches(websiteRegex)
    }

    // Social media URL validation function
    //fun isValidSocialMedia(socialMedia: String): Boolean {
    //    val socialMediaRegex = Regex("^(http(s)?://)?(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}(/[\\w.-]*)*/?")
     //   return socialMedia.matches(socialMediaRegex)
  //  }
}



            // if (profilePictureUri == null) {
              //   // No profile picture selected
             //    Toast.makeText(this, "Please select a profile picture", Toast.LENGTH_SHORT).show()
              //   return@setOnClickListener
           //  }

             // All fields are valid, proceed with form submission















    //fun openImagePicker(){
    // val intent = Intent(Intent.ACTION_GET_CONTENT)
     //   intent.type = "image/*"
      //  pickImageLauncher.launch(intent)












