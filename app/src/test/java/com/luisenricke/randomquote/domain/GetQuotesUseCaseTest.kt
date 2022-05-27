package com.luisenricke.randomquote.domain

import com.luisenricke.randomquote.data.QuoteRepository
import com.luisenricke.randomquote.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {

    // @RelaxedMockK // This annotation create reference if we no setup or inject
    // @Mock // This annotation force us to create the reference

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    /**
     * Because the test implements `coroutines` we need to execute the test with `runBlocking`
     */
    @Test
    fun `when the api doesn't return anything then get values from database`(): Unit = runBlocking {
        // Give
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        // When
        getQuotesUseCase()

        // Then
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
    }

    @Test
    fun `when the api return something then get values from api`(): Unit = runBlocking {
        //Given
        val myList = listOf(Quote("Test it", "LuisEnricke"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList

        //When
        val response = getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
        assert(response == myList)
    }

}
