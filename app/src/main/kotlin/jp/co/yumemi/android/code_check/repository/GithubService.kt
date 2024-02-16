package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.model.SearchGithubRepositoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    suspend fun searchGithubRepository(@Query("q") query: String): SearchGithubRepositoryModel
}