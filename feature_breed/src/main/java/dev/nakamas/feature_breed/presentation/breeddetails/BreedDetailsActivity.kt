package dev.nakamas.feature_breed.presentation.breeddetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import dev.nakamas.feature_breed.R
import dev.nakamas.feature_breed.di.injectFeature
import dev.nakamas.navigation.TokiNavigation
import kotlinx.android.synthetic.main.activity_breed_images.*
import kotlinx.android.synthetic.main.activity_breed_list.*
import kotlinx.android.synthetic.main.activity_breed_list.swipeRefreshLayout
import org.koin.androidx.viewmodel.ext.viewModel

class BreedDetailsActivity : AppCompatActivity() {

    private val KEY_PARAM_NAME = "KEY_PARAM_NAME"
    private val vm: BreedDetailsViewModel by viewModel()
    var nameBreed: String = ""

    private val itemClick: (String) -> Unit =
        { startActivity(TokiNavigation.postDetails(userId = it, postId = it)) }

    private val adapter = BreedDetailsAdapter(itemClick)

    private val snackBar by lazy {
        Snackbar.make(swipeRefreshLayout, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) { vm.get(nameBreed) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_list)
        injectFeature()

        if (savedInstanceState == null) {
            nameBreed = intent.getStringExtra(KEY_PARAM_NAME)
            vm.get(nameBreed)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvBreedImages.isNestedScrollingEnabled = false
        rvBreedImages.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
