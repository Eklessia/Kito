package dev.nakamas.feature_breed.datasource.model

import com.squareup.moshi.Json

data class GetAllBreedResponse(
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "message")
    var result: Map<String, List<String>>
)