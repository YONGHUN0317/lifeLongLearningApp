
import com.squareup.moshi.Json

data class Response(
    @Json(name = "body")
    val body: Body?,
    @Json(name = "header")
    val header: Header?
)