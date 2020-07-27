package com.kcb.android.tourismguide.ui.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_tour.*

class TourDetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour)

        val tourObject = intent.getParcelableExtra<TourParcelable>(TourDetailActivity.EXTRA_DATA)
        title_detail_view.text = tourObject?.title
        Picasso.get().load(tourObject?.photo).into(image_detail)
        detail_description.text = tourObject?.description
        detail_address.text = "Address : "+tourObject?.address
        detail_clock.text = "Open  : ${tourObject?.timeOpen} - ${tourObject?.timeClose}"
        detail_price.text = "Price : Rp. "+tourObject?.price
    }
}