package jp.co.yumemi.android.code_check.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.android.code_check.common.NetworkResponse
import jp.co.yumemi.android.code_check.common.State.GithubRepositoryState
import jp.co.yumemi.android.code_check.model.Item
import jp.co.yumemi.android.code_check.viewModel.utlil.SearchGithubUtil
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GithubDetailViewModel
@Inject
constructor(
    private val searchGithubUtil: SearchGithubUtil,
) : ViewModel() {
    private val _state = mutableStateOf(GithubRepositoryState<Item>())
    val state: State<GithubRepositoryState<Item>> = _state

    fun getGithubDetail(
        repo: String,
        owner: String,
    ) {
        searchGithubUtil.getRepositoryDetail(repo = repo, owner = owner).onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = GithubRepositoryState(isLoading = true)
                }
                is NetworkResponse.Failure -> {
                    _state.value = GithubRepositoryState(error = result.error)
                }
                is NetworkResponse.Success -> {
                    Log.d("Response", _state.value.data.toString())
                    _state.value = GithubRepositoryState(data = result.data)
                }
            }
        }
            .launchIn(viewModelScope)
    }
}
