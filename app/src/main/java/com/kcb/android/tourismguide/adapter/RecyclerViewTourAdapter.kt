package com.kcb.android.tourismguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cardview_tour.view.*

class RecyclerViewTourAdapter() : RecyclerView.Adapter<RecyclerViewTourAdapter.ViewHolder>() {
    private val mData = ArrayList<TourParcelable>()
    fun setData(items: ArrayList<TourParcelable>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tourParcelable: TourParcelable){
            with(itemView){
                Picasso.get().load(tourParcelable.photo).into(tour_image)
                tour_title.text = tourParcelable.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_tour, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}