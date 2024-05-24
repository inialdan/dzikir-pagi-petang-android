package inialdan.com.dzikirpagipetang.data.repository

import inialdan.com.dzikirpagipetang.data.api.ApiInterface
import inialdan.com.dzikirpagipetang.data.api.KtorApiClient
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem

class DzikirSholatRepository(private val apiClient: KtorApiClient) {

    private val apiInterface = ApiInterface()

    suspend fun getDzikirSholat(): List<DzikirResponseItem> {
        return apiInterface.fetchDzikirSholat(apiClient)
    }
}