package dev.nakamas.toki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //startBreeds()
    }

    //private fun startPosts() = TokiNavigation.dynamicStart?.let { startActivity(it) }
}
