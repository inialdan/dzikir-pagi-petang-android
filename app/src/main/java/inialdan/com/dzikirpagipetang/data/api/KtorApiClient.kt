package inialdan.com.dzikirpagipetang.data.api

import android.util.Log
import inialdan.com.dzikirpagipetang.data.remote.BaseResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.json.Json

class KtorApiClient {

    val tag = "KtorApiClient"

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d(tag, message)
                }
            }
        }
    }

    suspend inline fun <reified T> endPoint(url: String): BaseResponse<T> {
        val baseUrl = "https://api.inialdan.com/"
        return try {
            val builtUrl = URLBuilder(baseUrl + url).build()
            Log.d(tag, "Request URL: $builtUrl")
            val response: BaseResponse<T> = httpClient.get(builtUrl).body()
            Log.d(tag, "Response: $response")
            response
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e(tag, "IOException: ${e.message}", e)
            throw e
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(tag, "Exception: ${e.message}", e)
            throw e
        }
    }
}