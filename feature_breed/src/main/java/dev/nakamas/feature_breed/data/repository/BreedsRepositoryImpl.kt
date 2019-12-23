package dev.nakamas.feature_breed.data.repository

import dev.nakamas.feature_breed.data.datasource.BreedsDataSource
import dev.nakamas.feature_breed.domain.entity.Breeds
import dev.nakamas.feature_breed.domain.repository.BreedRepository
import io.reactivex.Single

class BreedsRepositoryImpl constructor(
    private val remoteDataSource: BreedsDataSource
) : BreedRepository {

    override fun getBreeds(): Single<Breeds> {
        return remoteDataSource.get()
    }
}