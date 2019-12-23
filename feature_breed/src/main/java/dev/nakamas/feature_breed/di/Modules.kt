package dev.nakamas.feature_breed.di

import dev.nakamas.feature_breed.BASE_URL
import dev.nakamas.feature_breed.BuildConfig
import dev.nakamas.feature_breed.data.datasource.BreedsDataSource
import dev.nakamas.feature_breed.data.datasource.BreedsImagesDataSource
import dev.nakamas.feature_breed.data.repository.BreedImagesRepositoryImpl
import dev.nakamas.feature_breed.data.repository.BreedsRepositoryImpl
import dev.nakamas.feature_breed.datasource.remote.BreedImagesApi
import dev.nakamas.feature_breed.datasource.remote.BreedsApi
import dev.nakamas.feature_breed.datasource.remote.BreedsImageRemoteDataSourceImpl
import dev.nakamas.feature_breed.datasource.remote.BreedsRemoteDataSourceImpl
import dev.nakamas.feature_breed.domain.repository.BreedRepository
import dev.nakamas.feature_breed.domain.repository.BreedsImagesRepository
import dev.nakamas.feature_breed.domain.usecase.GetAllBreedsUseCase
import dev.nakamas.feature_breed.domain.usecase.GetBreedImagesUseCase
import dev.nakamas.feature_breed.presentation.breeddetails.BreedDetailsViewModel
import dev.nakamas.feature_breed.presentation.breedlist.BreedListViewModel
import dev.nakamas.network.createNetworkClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        dataSourceModule,
        networkModule
    )
}

val viewModelModule: Module = module {
    viewModel { BreedListViewModel(useCase = get()) }
    viewModel { BreedDetailsViewModel(useCase = get()) }
}

val useCaseModule: Module = module {
    factory { GetAllBreedsUseCase(repository = get()) }
    factory { GetBreedImagesUseCase(repository = get()) }
}

val repositoryModule: Module = module {
    single { BreedImagesRepositoryImpl(remoteDataSource = get()) as BreedsImagesRepository }
    single { BreedsRepositoryImpl(remoteDataSource = get()) as BreedRepository }
}

val dataSourceModule: Module = module {
    single { BreedsImageRemoteDataSourceImpl(api = breedsImageApi) as BreedsImagesDataSource }
    single { BreedsRemoteDataSourceImpl(api = breedsApi) as BreedsDataSource }
}

val networkModule: Module = module {
    single { breedsApi }
    single { breedsImageApi }
}
private val retrofit: Retrofit = createNetworkClient(BASE_URL)
private val breedsApi: BreedsApi = retrofit.create(BreedsApi::class.java)
private val breedsImageApi: BreedImagesApi = retrofit.create(BreedImagesApi::class.java)