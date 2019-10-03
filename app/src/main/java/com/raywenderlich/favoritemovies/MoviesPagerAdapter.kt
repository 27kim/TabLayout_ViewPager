package com.raywenderlich.favoritemovies

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val MAX_VALUE = 200

class MoviesPagerAdapter(
        fragmentManager: FragmentManager
        , private val movies: ArrayList<Movie>
) : FragmentStatePagerAdapter(fragmentManager) {
    val TAG = "MoviesPagerAdapter"
    override fun getItem(position: Int): Fragment {
        Log.d(TAG, "current position : $position")
        return MovieFragment.newInstance(movies[position % movies.size])
    }

    override fun getCount(): Int {
        return movies.size * MAX_VALUE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return movies[position % movies.size].title
    }
}