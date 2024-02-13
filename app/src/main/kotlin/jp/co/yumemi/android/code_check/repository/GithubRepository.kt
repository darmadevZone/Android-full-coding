package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.common.NetworkResponse
import jp.co.yumemi.android.code_check.model.SearchGithubRepositoryModel
import java.util.concurrent.Flow
import javax.inject.Inject

class GithubRepository @Inject constructor(
   private val githubService: GithubService
){
    suspend fun searchGithubRepository(query: String): SearchGithubRepositoryModel{
        return githubService.searchGithubRepository(query)
    }
}