package dev.nakamas.feature_breed.presentation.model

import dev.nakamas.feature_breed.domain.entity.BreedImages

data class BreedImagesItem(
    val listUrlImages: List<String>
)

fun BreedImages.mapToPresentation(): BreedImagesItem =
    BreedImagesItem(listUrlImages)
