package dev.nakamas.feature_breed.data.datasource

import dev.nakamas.feature_breed.domain.entity.BreedImages
import dev.nakamas.feature_breed.domain.entity.Breeds
import io.reactivex.Single

interface BreedsImagesDataSource {
    fun get(name: String): Single<BreedImages>
}