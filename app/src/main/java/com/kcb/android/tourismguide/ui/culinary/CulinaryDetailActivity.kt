package com.kcb.android.tourismguide.ui.culinary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_culinary_detail.*

class CulinaryDetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culinary_detail)

        val culinaryObject = intent.getParcelableExtra<CulinaryParcelable>(EXTRA_DATA)
        title_detail_view.text = culinaryObject?.title
        Picasso.get().load(culinaryObject?.photo).into(image_detail)
        detail_description.text = culinaryObject?.description
        detail_address.text = "Address :"+culinaryObject?.address
        detail_clock.text = "Open  : ${culinaryObject?.timeOpen} - ${culinaryObject?.timeClose}"
        detail_price.text = "Price : Rp. "+culinaryObject?.price
    }
}