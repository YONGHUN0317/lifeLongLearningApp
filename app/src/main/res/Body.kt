
import com.squareup.moshi.Json

data class Body(
    @Json(name = "items")
    val items: List<Item?>?,
    @Json(name = "numOfRows")
    val numOfRows: String?,
    @Json(name = "pageNo")
    val pageNo: String?,
    @Json(name = "totalCount")
    val totalCount: String?
)