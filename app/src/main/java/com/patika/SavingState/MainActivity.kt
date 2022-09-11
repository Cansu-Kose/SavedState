package com.patika.SavingState

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val SOME_VALUE = "int_value"
    val SOME_OTHER_VALUE = "string_value"
    var someIntValue = 0
    var someStringValue: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Log.v("PATIKADEV","onCreate called.")
    }

/*
override fun onStart() {
    super.onStart()
    Log.v("PATIKADEV","onStart called.")
}*/

    override fun onResume() {
        val settings = getSharedPreferences("Settings", MODE_PRIVATE)
        someIntValue = settings.getInt(SOME_VALUE, 0)
        super.onResume()
    }
    @Override
    override fun onPause() {
    val settings = getSharedPreferences("Settings", Context.MODE_PRIVATE)
    val editor = settings.edit()
    editor.putInt(SOME_VALUE, someIntValue)
    editor.putString(SOME_OTHER_VALUE, someStringValue)
    editor.apply()
    super.onPause()
    }

/*
override fun onStop() {
    super.onStop()
    Log.v("PATIKADEV","onStop called.")
}

override fun onRestart() {
    super.onRestart()
    Log.v("PATIKADEV","onRestart called.")
}

override fun onDestroy() {
    super.onDestroy()
    Log.v("PATIKADEV","onDestroy called.")
}*/

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
         // Save custom values into the bundle
         savedInstanceState.putInt(SOME_VALUE, someIntValue)
         savedInstanceState.putString(SOME_OTHER_VALUE, someStringValue)
         // Always call the superclass so it can save the view hierarchy state
         super.onSaveInstanceState(savedInstanceState)
    }

    companion object {
        const val SOME_VALUE = "int_value"
        const val SOME_OTHER_VALUE = "string_value"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance
        val someIntValue = savedInstanceState.getInt(SOME_VALUE)
        val someStringValue = savedInstanceState.getString(SOME_OTHER_VALUE)
    }

}