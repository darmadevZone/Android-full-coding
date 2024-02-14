package jp.co.yumemi.android.code_check.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.yumemi.android.code_check.common.NetworkResponse
import jp.co.yumemi.android.code_check.common.State.GithubRepositoryState
import jp.co.yumemi.android.code_check.viewModel.utlil.SearchGithubUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SearchGithubViewModel @Inject constructor(
    private val searchGithubUtil: SearchGithubUtil
) : ViewModel(){
    private val _state = mutableStateOf(GithubRepositoryState())
    val state: State<GithubRepositoryState> = _state
    val query by mutableStateOf("")

    fun searchGithubRepository(): Flow<GithubRepositoryState> = flow{
        searchGithubUtil.searchGithubRepository(query).onEach {
            result ->
            when(result) {
                is NetworkResponse.Success -> {
                        _state.value = GithubRepositoryState(
                            data = result.data.items,
                            isLoading = false
                        )
                }

                is NetworkResponse.Failure -> {
                    _state.value = GithubRepositoryState(error = result.error)
                }
                is NetworkResponse.Loading ->{
                    _state.value = GithubRepositoryState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}