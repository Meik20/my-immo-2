package com.example.myimmo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myimmo2.ui.location.LocationScreen
import com.example.myimmo2.ui.theme.MyImmo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyImmo2Theme {
                LocationScreen()
            }
        }
    }
}
