package com.empty.search.di

import com.empty.core.data.BaseHttpClient
import com.empty.search.data.BaseSearchRepository
import com.empty.search.domain.SearchRepository
import org.koin.dsl.module

val searchModule = module {
    factory<SearchRepository> {
        BaseSearchRepository(
            BaseHttpClient(
                "https://www.googleapis" + ".com/customsearch/v1?key=${BuildConfig.SEARCH_TOKEN}&cx" + "=06c31479aa70a4318",
                ""
            )
        )
    }
}