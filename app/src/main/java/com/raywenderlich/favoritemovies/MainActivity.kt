package com.raywenderlich.favoritemovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nshmura.recyclertablayout.RecyclerTabLayout

class MainActivity : AppCompatActivity() {
  private lateinit var viewPager: ViewPager
  private lateinit var pagerAdapter: MoviesPagerAdapter
  private lateinit var recyclerTabLayout: RecyclerTabLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Get the list of movies from the JSON file
    val movies = MovieHelper.getMoviesFromJson("movies.json", this)
     pagerAdapter = MoviesPagerAdapter(supportFragmentManager, movies)

    viewPager = findViewById(R.id.viewPager)
    viewPager.adapter = pagerAdapter
    viewPager.currentItem = pagerAdapter.count / 2

    recyclerTabLayout = findViewById(R.id.recyclerTabLayout)
    recyclerTabLayout.setUpWithViewPager(viewPager)
  }
}
