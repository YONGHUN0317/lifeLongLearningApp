
import com.squareup.moshi.Json

data class Header(
    @Json(name = "resultCode")
    val resultCode: String?,
    @Json(name = "resultMsg")
    val resultMsg: String?,
    @Json(name = "type")
    val type: String?
)