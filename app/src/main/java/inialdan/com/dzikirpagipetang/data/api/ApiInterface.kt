package inialdan.com.dzikirpagipetang.data.api

import inialdan.com.dzikirpagipetang.data.remote.BaseResponse
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem

class ApiInterface {

    suspend fun fetchDzikirSholat(apiClient: KtorApiClient): List<DzikirResponseItem> {
        val url = "dzikir/dzikir-sholat.json"
        return try {
            val response: BaseResponse<List<DzikirResponseItem>> = apiClient.endPoint(url)
            response.result ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun fetchDzikirPagi(apiClient: KtorApiClient): List<DzikirResponseItem> {
        val url = "dzikir/dzikir-pagi.json"
        return try {
            val response: BaseResponse<List<DzikirResponseItem>> = apiClient.endPoint(url)
            response.result ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun fetchDzikirPetang(apiClient: KtorApiClient): List<DzikirResponseItem> {
        val url = "dzikir/dzikir-petang.json"
        return try {
            val response: BaseResponse<List<DzikirResponseItem>> = apiClient.endPoint(url)
            response.result ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}