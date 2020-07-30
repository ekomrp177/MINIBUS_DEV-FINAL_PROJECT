package com.kcb.android.tourismguide.ui.culinary

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.kcb.android.tourismguide.room.culinary.CulinaryDatabase
import com.kcb.android.tourismguide.ui.home.HomeFragment
import com.kcb.android.tourismguide.ui.maps.MapsFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_culinary_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CulinaryDetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }
    private var culinaryDatabase : CulinaryDatabase? = null
    private var isFavorite: Boolean = false
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culinary_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        culinaryDatabase = CulinaryDatabase.getInstance(this)

        val culinaryObject = intent.getParcelableExtra<CulinaryParcelable>(EXTRA_DATA)
        title_detail_view.text = culinaryObject?.title
        Picasso.get().load(culinaryObject?.photo).into(image_detail)
        detail_description.text = culinaryObject?.description
        detail_address.text = culinaryObject?.address
        detail_clock.text = culinaryObject?.timeOpen+" - "+culinaryObject?.timeClose
        detail_price.text = "Rp. "+culinaryObject?.price

        supportFragmentManager.beginTransaction().replace(R.id.maps_detail_culinary, MapsFragment()).commit()
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
                val culinaryCheck = culinaryDatabase!!.culinaryDao().getAll()
                if (culinaryCheck.isNotEmpty()){
                    for (i in culinaryCheck.indices){
                        if (culinaryCheck[i].title == culinaryObject?.title){
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
                    culinaryDatabase?.culinaryDao()?.delete(culinaryObject?.title)
                }
                isFavorite = false
            }else{
                if (culinaryObject?.title != null){
                    fab_favorite.setImageResource(R.drawable.ic_added)
                    Snackbar.make(view, "Added to favorite", Snackbar.LENGTH_SHORT).show()
                    GlobalScope.launch {
                        this.let {
                            culinaryDatabase?.culinaryDao()?.insert(culinaryObject)
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