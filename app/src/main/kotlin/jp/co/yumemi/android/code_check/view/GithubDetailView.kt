package jp.co.yumemi.android.code_check.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import jp.co.yumemi.android.code_check.ui.theme.Typography
import jp.co.yumemi.android.code_check.viewModel.GithubDetailViewModel

@Composable
fun GithubDetailView(
    goToSearchView: () -> Unit,
    viewModel: GithubDetailViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val state = viewModel.state.value
        val ctx = LocalContext.current
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            !state.error.isNullOrBlank() -> {
                Toast.makeText(ctx, "レポジトリを検索できませんでした", Toast.LENGTH_LONG).show()
                Log.d("Error", state.error)
            }

            state.data != null -> {
                AsyncImage(
                    model = state.data.owner.avatarUrl,
                    contentDescription = state.data.name,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(text = state.data.name, style = Typography.bodyLarge)
                    Text(text = state.data.language ?: "No Language", style = Typography.bodyLarge)
                    Text(text = "Star Count: ${state.data.stargazersCount}", style = Typography.bodyLarge)
                    Text(text = "watcherCount ${state.data.watchersCount}", style = Typography.bodyLarge)
                    Text(text = "forkCount: ${state.data.forksCount}", style = Typography.bodyLarge)
                    Text(text = "owner: ${state.data.owner}")
                }
            }
        }
    }
}
