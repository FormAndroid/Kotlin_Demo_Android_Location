package be.bxl.formation.demo_android_kotlin_gps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import be.bxl.formation.demo_android_kotlin_gps.helpers.LocationHelper

class MainActivity : AppCompatActivity() {

    lateinit var btnLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationHelper: LocationHelper = LocationHelper(this) { coordinate ->
            val msg: String = "Lat: ${coordinate.lat} / Lon: ${coordinate.lon}"
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }

        btnLocation = findViewById(R.id.btn_main_location)
        btnLocation.setOnClickListener {
            locationHelper.getLastLocation()
        }
    }
}