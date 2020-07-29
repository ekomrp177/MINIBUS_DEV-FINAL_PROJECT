package com.kcb.android.tourismguide.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.ui.culinary.CulinaryFragment
import com.kcb.android.tourismguide.ui.favorite.culinaryfav.CulinaryFavoriteFragment
import com.kcb.android.tourismguide.ui.favorite.tourfav.TourFavoriteFragment
import com.kcb.android.tourismguide.ui.tour.TourFragment

class FavoritePagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_tour, R.string.tab_culinary)

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = TourFavoriteFragment()
            1 -> fragment = CulinaryFavoriteFragment()
        }
        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }

}