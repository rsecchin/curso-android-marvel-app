package com.example.core.usecase

import androidx.paging.PagingConfig
import com.example.core.data.repository.CharacterRepository
import com.example.testing.MainCoroutineRule
import com.example.testing.model.CharacterFactory
import com.example.testing.pagingsource.PagingSourceFactory
import com.example.usecase.GetCharactersUseCase
import com.example.usecase.GetCharactersUseCaseImpl
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseImplTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: CharacterRepository

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    private val hero = CharacterFactory().create(CharacterFactory.Hero.ThreeDMan)

    private val fakePagingSource = PagingSourceFactory().create(listOf(hero))

    @Before
    fun setUp() {
        getCharactersUseCase = GetCharactersUseCaseImpl(repository)
    }

    @Test
    fun `should validate paging data creation when invoke for use case is called `() = runTest {

        whenever(repository.getCharacters("")).thenReturn(fakePagingSource)


        val result = getCharactersUseCase.invoke(
            GetCharactersUseCase.GetCharactersParams(
                "",
                PagingConfig(20)
            )
        )

        verify(repository).getCharacters("")

        assertNotNull(result.first())
    }
}