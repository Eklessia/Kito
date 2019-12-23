package dev.nakamas.feature_breed.datasource.remote

import dev.nakamas.feature_breed.datasource.model.GetAllBreedResponse
import dev.nakamas.feature_breed.datasource.model.GetBreedImagesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedsApi {
    @GET("breeds/list/all")
    fun getAllBreedsAsync(): Single<GetAllBreedResponse>
}

interface BreedImagesApi {
    @GET("breed/{name}/images")
    fun getBreedImages(@Path("name") name: String): Single<GetBreedImagesResponse>
}
