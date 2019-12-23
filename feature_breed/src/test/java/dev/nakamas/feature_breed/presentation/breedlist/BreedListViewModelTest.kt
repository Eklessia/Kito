package dev.nakamas.feature_breed.presentation.breedlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.nakamas.feature_breed.RxImmediateSchedulerRule
import dev.nakamas.feature_breed.domain.usecase.GetAllBreedsUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule

class BreedListViewModelTest {

    @MockK
    lateinit var fakeUseCase: GetAllBreedsUseCase

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var viewModel: BreedListViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = BreedListViewModel(fakeUseCase)
    }
}