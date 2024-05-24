package inialdan.com.dzikirpagipetang.data.repository

import inialdan.com.dzikirpagipetang.data.api.ApiInterface
import inialdan.com.dzikirpagipetang.data.api.KtorApiClient
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem

class DzikirPagiRepository(private val apiClient: KtorApiClient) {

    private val apiInterface = ApiInterface()

    suspend fun getDzikirPagi(): List<DzikirResponseItem> {
        return apiInterface.fetchDzikirPagi(apiClient)
    }
}