package dev.nakamas.feature_breed.presentation.breeddetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.nakamas.feature_breed.domain.usecase.GetAllBreedsUseCase
import dev.nakamas.feature_breed.domain.usecase.GetBreedImagesUseCase
import dev.nakamas.feature_breed.presentation.model.BreedImagesItem
import dev.nakamas.feature_breed.presentation.model.BreedsItem
import dev.nakamas.feature_breed.presentation.model.mapToPresentation
import dev.nakamas.presentation.Resource
import dev.nakamas.presentation.setError
import dev.nakamas.presentation.setLoading
import dev.nakamas.presentation.setSuccess
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BreedDetailsViewModel constructor(private val useCase: GetBreedImagesUseCase) :
    ViewModel() {

    val listImages = MutableLiveData<Resource<BreedImagesItem>>()
    private val compositeDisposable = CompositeDisposable()

    fun get(nameBreed: String) =
        compositeDisposable.add(useCase.getBreedImages(nameBreed)
            .doOnSubscribe { listImages.setLoading() }
            .subscribeOn(Schedulers.io())
            .map { it.mapToPresentation() }
            .subscribe({ listImages.setSuccess(it) }, { listImages.setError(it.message) })
        )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
