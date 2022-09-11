package com.patika.SavingState

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ParentActivity : AppCompatActivity() {
    private var fragmentSimple: HomeFragment? = null
    private val SIMPLE_FRAGMENT_TAG = "myfragmenttag"

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        if (savedInstanceState != null) { // saved instance state, fragment may exist
            // look up the instance that already exists by tag
            fragmentSimple =
                supportFragmentManager.findFragmentByTag(SIMPLE_FRAGMENT_TAG) as HomeFragment?
        } else if (fragmentSimple == null) {
            // only create fragment if they haven't been instantiated already
            fragmentSimple = HomeFragment()
        }
    }
}