package jp.co.yumemi.android.code_check

sealed class ViewRoute(val route: String) {
    object SearchGithubView : ViewRoute("searchGithubView")

    object GithubDetailView : ViewRoute("githubDetailView/{owner}/{repo}")
}
