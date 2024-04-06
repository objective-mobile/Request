package com.empty.search.data

import com.empty.core.data.BaseHttpClient
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryUnitTest {
    @Test
    fun queryTest() {
        runBlocking {
            println(
                BaseSearchRepository(
                    BaseHttpClient(
                        "https://www.googleapis" + ".com/customsearch/v1?key=${BuildConfig.SEARCH_TOKEN}&cx" + "=06c31479aa70a4318",
                        ""
                    )
                ).request("What the capital of London?")
            )
        }

    }
}