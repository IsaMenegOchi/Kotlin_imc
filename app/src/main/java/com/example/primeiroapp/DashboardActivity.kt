package com.example.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()
    }


}