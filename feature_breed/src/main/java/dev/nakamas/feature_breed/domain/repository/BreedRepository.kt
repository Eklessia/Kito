package dev.nakamas.feature_breed.domain.repository

import dev.nakamas.feature_breed.domain.entity.Breeds
import io.reactivex.Single

interface BreedRepository {
    fun getBreeds(): Single<Breeds>
}