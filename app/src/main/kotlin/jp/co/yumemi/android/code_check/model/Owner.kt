package jp.co.yumemi.android.code_check.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Owner(
    @Json(name = "avatar_url") val avatarUrl: String
)
