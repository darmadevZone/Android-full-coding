package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.model.Item
import jp.co.yumemi.android.code_check.model.SearchGithubRepositoryModel
import javax.inject.Inject

class GithubRepository
@Inject
constructor(
    private val githubService: GithubService,
) {
    suspend fun searchGithubRepository(query: String): SearchGithubRepositoryModel {
        return githubService.searchGithubRepository(query)
    }

    suspend fun getGithubDetail(
        owner: String,
        name: String,
    ): Item {
        TODO()
    }
}
