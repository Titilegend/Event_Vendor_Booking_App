package com.example.eventvendorbookingapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventvendorbookingapp.databinding.RecommendLikedListBinding
import com.example.eventvendorbookingapp.databinding.VendorListBinding

class RecommendAdapter(private val recommendList: ArrayList<VendorDetails>): RecyclerView.Adapter<RecommendAdapter.ViewHolder>()  {
    inner class ViewHolder(val recommendBinding: RecommendLikedListBinding)
        : RecyclerView.ViewHolder(recommendBinding.root){
        //val circleImageView: CircleImageView = adapterBinding.imageList2

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val recomBinding = RecommendLikedListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(recomBinding)
    }

    override fun getItemCount(): Int {
        return  recommendList.size

    }

    override fun onBindViewHolder(holder: RecommendAdapter.ViewHolder, position: Int) {
        holder.recommendBinding.nameTextView2.text = recommendList[position].fullName
        holder.recommendBinding.categoryTextView2.text = recommendList[position].servicesRendered
        holder.recommendBinding.priceTextView2.text = recommendList[position].pricing


        holder.recommendBinding.cardView2.setOnClickListener {
            val intent = Intent(it.context,VendorProfileDetail::class.java)
            intent.putExtra("name2",recommendList[position].fullName)
            intent.putExtra("location2",recommendList[position].location)
            intent.putExtra("phoneNumber2",recommendList[position].contactInfo)
            intent.putExtra("servicesRendered2",recommendList[position].servicesRendered)
            intent.putExtra("otherServices2",recommendList[position].otherServices)
            intent.putExtra("teamSize2",recommendList[position].teamSize)
            intent.putExtra("pricing2",recommendList[position].pricing)
            // intent.putExtra("imageUrl",imageUrl)
            intent.putExtra("website2",recommendList[position].website)
            intent.putExtra("socialMediaLink2",recommendList[position].socialMedia)
            intent.putExtra("description2",recommendList[position].description)
            intent.putExtra("accountDetails2",recommendList[position].accountDetails)
            it.context.startActivity(intent)
        }
    }
    fun setData(newVendorList: List<VendorDetails>) {
        recommendList.clear()
        recommendList.addAll(newVendorList)
        notifyDataSetChanged()
    }


}