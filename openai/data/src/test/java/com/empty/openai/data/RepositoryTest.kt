package com.empty.openai.data

import com.empty.core.data.BaseHttpClient
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryTest {
    @Test
    fun requestTest(){
        val repository = BaseAiRepository(BaseHttpClient("", ""))
        runBlocking {
            repository.requestAi("What the capital of London?")
        }
    }
}