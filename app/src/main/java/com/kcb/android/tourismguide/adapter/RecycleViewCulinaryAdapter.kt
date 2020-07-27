package com.kcb.android.tourismguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cardview_culinary.view.*

class RecycleViewCulinaryAdapter: RecyclerView.Adapter<RecycleViewCulinaryAdapter.ViewHolder>() {
    private val mData = ArrayList<CulinaryParcelable>()
    fun setData(items: ArrayList<CulinaryParcelable>){
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }
    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    private var onItemClickCallBack : OnItemClickCallBack? = null
    interface OnItemClickCallBack{
        fun onItemClicked(culinaryParcelable: CulinaryParcelable)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(culinaryParcelable: CulinaryParcelable){
            with(itemView){
                Picasso.get().load(culinaryParcelable.photo).into(culinary_image)
                culinary_title.text = culinaryParcelable.title
            }
            itemView.setOnClickListener { onItemClickCallBack?.onItemClicked(culinaryParcelable) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_culinary, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}