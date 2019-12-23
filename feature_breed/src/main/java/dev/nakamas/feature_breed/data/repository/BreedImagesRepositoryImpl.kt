package dev.nakamas.feature_breed.data.repository

import dev.nakamas.feature_breed.data.datasource.BreedsImagesDataSource
import dev.nakamas.feature_breed.domain.entity.BreedImages
import dev.nakamas.feature_breed.domain.repository.BreedsImagesRepository
import io.reactivex.Single

class BreedImagesRepositoryImpl constructor(
    private val remoteDataSource: BreedsImagesDataSource
) : BreedsImagesRepository {

    override fun getBreedImages(breedName: String): Single<BreedImages> {
        return remoteDataSource.get(breedName)
    }
}