package jp.co.yumemi.android.code_check.viewModel.utlil

import jp.co.yumemi.android.code_check.common.NetworkResponse
import jp.co.yumemi.android.code_check.model.Item
import jp.co.yumemi.android.code_check.model.SearchGithubRepositoryModel
import jp.co.yumemi.android.code_check.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchGithubUtil
@Inject
constructor(
    private val githubRepository: GithubRepository,
) {
    // query -> searchGithubRepositoryで検索 -> responseの取得
    fun searchGithubRepository(query: String): Flow<NetworkResponse<SearchGithubRepositoryModel>> =
        flow {
            try {
                emit(NetworkResponse.Loading())
                val result = githubRepository.searchGithubRepository(query)
                emit(NetworkResponse.Success(data = result))
            } catch (e: Exception) {
                emit(NetworkResponse.Failure(error = e.toString()))
            }
        }

    fun getRepositoryDetail(
        repo: String,
        owner: String,
    ): Flow<NetworkResponse<Item>> =
        flow {
            try {
                emit(NetworkResponse.Loading())
                val result = githubRepository.getGithubDetail(owner = owner, repo = repo)
                emit(NetworkResponse.Success(data = result))
            } catch (e: Exception) {
                emit(NetworkResponse.Failure(error = e.toString()))
            }
        }
}
