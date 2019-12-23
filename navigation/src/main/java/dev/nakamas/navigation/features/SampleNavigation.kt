package dev.nakamas.navigation

import android.content.Intent

object TokiNavigation : DynamicFeature<Intent> {

    const val USER_ID_KEY = "USER_ID_KEY"
    const val POST_ID_KEY = "POST_ID_KEY"

    private const val BREED_LIST = "dev.nakamas.breedlist.MainActivity"
    private const val BREED_DETAIlS = "dev.nakamas.breedlist.MainActivity"

    override val dynamicStart: Intent?
        get() = BREED_LIST.loadIntentOrNull()

    fun postDetails(userId: String, postId: String): Intent? =
        BREED_DETAIlS.loadIntentOrNull()
            ?.apply {
                putExtra(USER_ID_KEY, userId)
                putExtra(POST_ID_KEY, postId)
            }
}
