package com.example.eventvendorbookingapp

data class VendorDetails(
    val vendorId:String = "",
    //val url:String = "",
    //var image:String = "",

    val contactInfo:String = "",
    val location: String = "",
    val servicesRendered:String = "",
    val fullName:String = "",
    val otherServices:String ="",
    val teamSize:String = "",
    val website:String = "",
    val socialMedia:String = "",
    val pricing:String = "",
    val description:String = "",
    val accountDetails:String = "",
    val liked:Boolean = true
)