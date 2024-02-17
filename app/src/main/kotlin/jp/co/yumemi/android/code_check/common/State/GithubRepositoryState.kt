package jp.co.yumemi.android.code_check.common.State

data class GithubRepositoryState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null,
)
