package com.empty.openai.data

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryTest {
    @Test
    fun requestTest(){
        val repository = BaseAiRepository(HttpClient.httpClient())
        runBlocking {
            repository.requestAi("What the capital of London?")
        }
    }
}