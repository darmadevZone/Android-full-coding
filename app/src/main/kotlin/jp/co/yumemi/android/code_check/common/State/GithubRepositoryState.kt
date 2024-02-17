package jp.co.yumemi.android.code_check.common.State

import jp.co.yumemi.android.code_check.model.Item

data class GithubRepositoryState(
    val isLoading: Boolean = false,
    val data: List<Item> = emptyList(),
    val error: String? = null
)
