package dev.nakamas.feature_breed

import org.koin.core.context.loadKoinModules

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        //viewModelModule,
        //useCaseModule,
        //repositoryModule,
        //dataSourceModule,
        //networkModule,
        //cacheModule
    )
}