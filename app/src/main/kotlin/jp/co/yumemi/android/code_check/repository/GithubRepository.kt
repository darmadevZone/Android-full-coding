package jp.co.yumemi.android.code_check.repository

import android.util.Log
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
        repo: String,
    ): Item {
        Log.d("GithubRepository", githubService.getGithubDetail(owner, repo).toString())
        return githubService.getGithubDetail(owner, repo)
    }
}
