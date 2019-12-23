package dev.nakamas.feature_breed.domain.repository

import dev.nakamas.feature_breed.domain.entity.BreedImages
import io.reactivex.Single

interface BreedsImagesRepository {
    fun getBreedImages(breedName: String): Single<BreedImages>
}