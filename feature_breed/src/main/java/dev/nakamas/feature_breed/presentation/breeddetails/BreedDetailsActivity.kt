package dev.nakamas.feature_breed.presentation.breeddetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import dev.nakamas.feature_breed.R
import dev.nakamas.feature_breed.di.injectFeature
import dev.nakamas.feature_breed.presentation.model.BreedImagesItem
import dev.nakamas.navigation.features.TokiNavigation
import dev.nakamas.presentation.Resource
import dev.nakamas.presentation.ResourceState
import dev.nakamas.presentation.startRefreshing
import dev.nakamas.presentation.stopRefreshing
import kotlinx.android.synthetic.main.activity_breed_images.*
import kotlinx.android.synthetic.main.activity_breed_list.*
import kotlinx.android.synthetic.main.activity_breed_list.swipeRefreshLayout
import org.koin.androidx.viewmodel.ext.viewModel

class BreedDetailsActivity : AppCompatActivity() {

    private val vm: BreedDetailsViewModel by viewModel()
    var nameBreed: String = ""

    private val itemClick: (String) -> Unit = { }

    private val adapter = BreedDetailsAdapter(itemClick)

    private val snackBar by lazy {
        Snackbar.make(swipeRefreshLayout, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) { vm.get(nameBreed) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_images)
        injectFeature()

        if (savedInstanceState == null) {
            nameBreed = intent.getStringExtra(TokiNavigation.BREED_NAME)
            vm.get(nameBreed)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvBreedImages.isNestedScrollingEnabled = false
        rvBreedImages.adapter = adapter

        vm.listImages.observe(this, Observer { updateBreedListImages(it) })
    }

    private fun updateBreedListImages(resource: Resource<BreedImagesItem>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> swipeRefreshLayout.startRefreshing()
                ResourceState.SUCCESS -> swipeRefreshLayout.stopRefreshing()
                ResourceState.ERROR -> swipeRefreshLayout.stopRefreshing()
            }
            it.data?.let {
                adapter.submitList(it.listUrlImages)
            }
            it.message?.let {
                snackBar.show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
