package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.model.SearchGithubRepositoryModel
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun searchGithubRepository(query: String): SearchGithubRepositoryModel {
        return githubService.searchGithubRepository(query)
    }
}
