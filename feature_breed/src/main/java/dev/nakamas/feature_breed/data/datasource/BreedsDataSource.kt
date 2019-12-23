package dev.nakamas.feature_breed.data.datasource

import dev.nakamas.feature_breed.domain.entity.Breeds
import io.reactivex.Single

interface BreedsDataSource {
    fun get(): Single<Breeds>
}
