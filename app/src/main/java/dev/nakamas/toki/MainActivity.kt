package dev.nakamas.toki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.nakamas.navigation.features.TokiNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBreeds()
        finish()
    }

    private fun startBreeds() =
        TokiNavigation.dynamicStart?.let { startActivity(TokiNavigation.goToBreedList()) }
}
