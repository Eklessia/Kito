package dev.nakamas.feature_breed.domain.usecase

import dev.nakamas.feature_breed.domain.repository.BreedsImagesRepository

class GetBreedImagesUseCase(
    private val repository: BreedsImagesRepository
) {

    fun getBreedImages(name: String) = repository.getBreedImages(name)
}