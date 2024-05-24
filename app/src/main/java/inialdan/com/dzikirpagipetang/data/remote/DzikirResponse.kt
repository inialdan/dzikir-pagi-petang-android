package inialdan.com.dzikirpagipetang.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class DzikirResponseItem(
    val read: String? = null,
    val arabic: String? = null,
    val translation: String? = null,
    val id: Int? = null,
    val latin: String? = null,
    val source: String? = null,
    val benefit: String? = null
)
