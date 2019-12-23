package dev.nakamas.navigation.features

import android.content.Intent
import dev.nakamas.navigation.loadIntentOrNull

object TokiNavigation : DynamicFeature<Intent> {

    const val BREED_NAME = "BREED_NAME"

    private const val BREED_LIST = "dev.nakamas.feature_breed.presentation.breedlist.BreedListActivity"
    private const val BREED_DETAIlS = "dev.nakamas.feature_breed.presentation.breeddetails.BreedDetailsActivity"

    override val dynamicStart: Intent?
        get() = BREED_LIST.loadIntentOrNull()

    fun goToBreedList():Intent? =
        BREED_LIST.loadIntentOrNull()

    fun goToBreedImages(nameBreed: String): Intent? =
        BREED_DETAIlS.loadIntentOrNull()
            ?.apply {
                putExtra(BREED_NAME, nameBreed)
            }
}
