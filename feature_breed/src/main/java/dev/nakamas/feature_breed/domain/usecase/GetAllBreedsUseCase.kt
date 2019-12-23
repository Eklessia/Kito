package dev.nakamas.feature_breed.domain.usecase

import dev.nakamas.feature_breed.domain.repository.BreedRepository

class GetAllBreedsUseCase(
    private val repository: BreedRepository
) {

    fun getBreds() = repository.getBreeds()

}