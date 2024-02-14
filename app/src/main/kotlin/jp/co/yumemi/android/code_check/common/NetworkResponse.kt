package jp.co.yumemi.android.code_check.common

sealed class NetworkResponse<T>(
    val error: String? = null,
) {

    class Success<T>(val data: T) : NetworkResponse<T>()
    class Failure<T>(error: String) : NetworkResponse<T>(error = error)
    class Loading<T> : NetworkResponse<T>()
}
