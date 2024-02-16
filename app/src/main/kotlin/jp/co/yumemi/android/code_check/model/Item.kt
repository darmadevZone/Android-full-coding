package jp.co.yumemi.android.code_check.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// /val name: String,
// val ownerIconUrl: OwnerList,
@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "name")
    val name: String,
    @Json(name = "forks_count")
    val forksCount: Int?,
    @Json(name = "open_issues_count")
    val openIssuesCount: Int,
    val language: String?,
    @Json(name = "stargazers_count")
    val stargazersCount: Int?,
    @Json(name = "watchers_count")
    val watchersCount: Int?,
    val owner: Owner,
)
