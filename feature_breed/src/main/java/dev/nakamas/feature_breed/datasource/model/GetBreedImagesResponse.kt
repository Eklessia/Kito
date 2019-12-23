package dev.nakamas.feature_breed.datasource.model

import com.squareup.moshi.Json

data class GetBreedImagesResponse(
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "message")
    var result: List<String>
)