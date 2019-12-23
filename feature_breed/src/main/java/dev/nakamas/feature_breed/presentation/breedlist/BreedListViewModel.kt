package dev.nakamas.feature_breed.presentation.breedlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.nakamas.feature_breed.domain.usecase.GetAllBreedsUseCase
import dev.nakamas.feature_breed.presentation.model.BreedsItem
import dev.nakamas.feature_breed.presentation.model.mapToPresentation
import dev.nakamas.presentation.Resource
import dev.nakamas.presentation.setError
import dev.nakamas.presentation.setLoading
import dev.nakamas.presentation.setSuccess
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BreedListViewModel constructor(private val useCase: GetAllBreedsUseCase) :
    ViewModel() {

    val posts = MutableLiveData<Resource<BreedsItem>>()
    private val compositeDisposable = CompositeDisposable()

    fun get() =
        compositeDisposable.add(useCase.getBreds()
            .doOnSubscribe { posts.setLoading() }
            .subscribeOn(Schedulers.io())
            .map { it.mapToPresentation() }
            .subscribe({ posts.setSuccess(it) }, { posts.setError(it.message) })
        )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
