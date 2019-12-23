package dev.nakamas.feature_breed.presentation.breedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import dev.nakamas.feature_breed.R
import dev.nakamas.feature_breed.di.injectFeature
import dev.nakamas.feature_breed.presentation.model.BreedsItem
import dev.nakamas.navigation.TokiNavigation
import dev.nakamas.presentation.Resource
import dev.nakamas.presentation.ResourceState
import dev.nakamas.presentation.startRefreshing
import dev.nakamas.presentation.stopRefreshing
import kotlinx.android.synthetic.main.activity_breed_list.*
import org.koin.androidx.viewmodel.ext.viewModel

class BreedListActivity : AppCompatActivity() {

    private val vm: BreedListViewModel by viewModel()

    private val itemClick: (String) -> Unit =
        { startActivity(TokiNavigation.postDetails(userId = it, postId = it)) }
    private val adapter = BreedListAdapter(itemClick)
    private val snackBar by lazy {
        Snackbar.make(swipeRefreshLayout, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) { vm.get() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_list)

        injectFeature()

        if (savedInstanceState == null) {
            vm.get()
        }

        rvBreedList.adapter = adapter

        vm.breedList.observe(this, Observer { updateBreedList(it) })
        swipeRefreshLayout.setOnRefreshListener { vm.get() }
    }

    private fun updateBreedList(resource: Resource<BreedsItem>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> swipeRefreshLayout.startRefreshing()
                ResourceState.SUCCESS -> swipeRefreshLayout.stopRefreshing()
                ResourceState.ERROR -> swipeRefreshLayout.stopRefreshing()
            }
            it.data?.let { adapter.submitList(it.breds) }
            it.message?.let { snackBar.show() }
        }
    }
}
