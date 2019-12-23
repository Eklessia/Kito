package dev.nakamas.feature_breed.datasource.remote

import dev.nakamas.feature_breed.data.datasource.BreedsDataSource
import dev.nakamas.feature_breed.domain.entity.Breeds
import io.reactivex.Single

class BreedsRemoteDataSourceImpl constructor(
    private val api: BreedsApi
) : BreedsDataSource {

    override fun get(): Single<Breeds> =
        api.getAllBreedsAsync().map {
            Breeds(it.result.keys.toList())
        }

}
