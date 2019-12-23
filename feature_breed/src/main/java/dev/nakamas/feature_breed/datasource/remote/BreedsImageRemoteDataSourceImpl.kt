package dev.nakamas.feature_breed.datasource.remote

import dev.nakamas.feature_breed.data.datasource.BreedsImagesDataSource
import dev.nakamas.feature_breed.domain.entity.BreedImages
import io.reactivex.Single

class BreedsImageRemoteDataSourceImpl constructor(
    private val api: BreedsApi
) : BreedsImagesDataSource {

    override fun get(name: String): Single<BreedImages> =
        api.getBreedImages(name).map {
            BreedImages(it.result)
        }
}
