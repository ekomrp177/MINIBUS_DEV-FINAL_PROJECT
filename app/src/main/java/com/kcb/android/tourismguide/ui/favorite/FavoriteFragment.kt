package com.kcb.android.tourismguide.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.kcb.android.tourismguide.MainActivity.Companion.job
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.FavoritePagerAdapter
import com.kcb.android.tourismguide.ui.about.AboutActivity
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        job?.cancel()
        val favoritePagerAdapter = FavoritePagerAdapter(layoutInflater.context, childFragmentManager)
        view_pager.adapter = favoritePagerAdapter
        tabs.setupWithViewPager(view_pager)
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_about -> {
                val intent = Intent(context, AboutActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }


}