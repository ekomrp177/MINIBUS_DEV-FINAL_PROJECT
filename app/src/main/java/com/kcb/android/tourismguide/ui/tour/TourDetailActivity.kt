package com.kcb.android.tourismguide.ui.tour

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.kcb.android.tourismguide.room.tour.TourDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tour_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TourDetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }
    private var tourDatabase: TourDatabase? = null
    private var isFavorite = false
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tourDatabase = TourDatabase.getInstance(this)

        val tourObject = intent.getParcelableExtra<TourParcelable>(TourDetailActivity.EXTRA_DATA)
        title_detail_view.text = tourObject?.title
        Picasso.get().load(tourObject?.photo).into(image_detail)
        detail_description.text = tourObject?.description
        detail_address.text = tourObject?.address
        detail_clock.text = tourObject?.timeOpen +" - "+ tourObject?.timeClose
        detail_price.text = "Rp. "+tourObject?.price

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.isIndeterminate
        progressDialog.setCancelable(false)
        progressDialog.show()

        Handler().postDelayed({
            progressDialog.dismiss()
        }, 1000)
        GlobalScope.launch {
            this.let {
                val tourCheck = tourDatabase!!.tourDao().getAll()
                if (tourCheck.isNotEmpty()){
                    for (i in tourCheck.indices){
                        if (tourCheck[i].title == tourObject?.title){
                            fab_favorite.setImageResource(R.drawable.ic_added)
                            isFavorite = true
                            break
                        }
                    }
                }
                else{
                    fab_favorite.setImageResource(R.drawable.ic_removed)
                    isFavorite = false
                }
            }
        }

        fab_favorite.setOnClickListener { view ->
            if (isFavorite){
                fab_favorite.setImageResource(R.drawable.ic_removed)
                Snackbar.make(view, "Removed from favorite", Snackbar.LENGTH_SHORT).show()
                GlobalScope.launch {
                    tourDatabase?.tourDao()?.delete(tourObject?.title)
                }
                isFavorite = false
            }else{
                if (tourObject?.title != null){
                    fab_favorite.setImageResource(R.drawable.ic_added)
                    Snackbar.make(view, "Added to favorite", Snackbar.LENGTH_SHORT).show()
                    GlobalScope.launch {
                        this.let {
                            tourDatabase?.tourDao()?.insert(tourObject!!)
                        }
                    }
                    isFavorite = true
                }else{
                    Snackbar.make(view, "Cannot add to favorite", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
            finish()
        }
        else {
            supportFragmentManager.popBackStack()
            finish()
        }
    }
}