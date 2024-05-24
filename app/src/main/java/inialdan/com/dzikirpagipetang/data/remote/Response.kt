package inialdan.com.dzikirpagipetang.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val code: Int? = 0,
    val count: Int? = 0,
    val `object`: T? = null,
    val data: T? = null,
    val results: T? = null,
    val result: T? = null,
    val message: String? = "",
    val status: Boolean? = false,
    val success: Boolean? = false,
    val error: String? = "",
)