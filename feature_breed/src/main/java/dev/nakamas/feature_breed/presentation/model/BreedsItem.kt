package dev.nakamas.feature_breed.presentation.model

import androidx.lifecycle.Transformations.map
import dev.nakamas.feature_breed.domain.entity.Breeds
import dev.nakamas.feature_breed.domain.usecase.GetAllBreedsUseCase

data class BreedsItem(
    val breds: List<String>
)

fun Breeds.mapToPresentation(): BreedsItem =
    BreedsItem(breds)