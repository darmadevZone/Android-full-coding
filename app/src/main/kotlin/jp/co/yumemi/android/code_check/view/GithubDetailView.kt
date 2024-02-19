package jp.co.yumemi.android.code_check.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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

@OptIn(ExperimentalMaterial3Api::class)
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
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(text = state.data.owner.name)
                            },
                            navigationIcon = {
                                IconButton(onClick = { goToSearchView() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "戻る",
                                    )
                                }
                            },
                        )
                    },
                ) { inner ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(inner),
                    ) {
                        AsyncImage(
                            model = state.data.owner.avatarUrl,
                            contentDescription = state.data.name,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                        )
                        Column(
                            verticalArrangement =
                                Arrangement.spacedBy(
                                    20.dp,
                                    Alignment.CenterVertically,
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Text(
                                text = "${state.data.owner.name}/${state.data.name}",
                                style = Typography.bodyLarge,
                            )
                            Spacer(modifier = Modifier)
                            val language = state.data.language ?: "No Language"
                            Text(
                                text = "programming language: $language",
                                style = Typography.bodyLarge,
                            )
                            Spacer(modifier = Modifier)
                            Text(
                                text = "Star Count: ${state.data.stargazersCount}",
                                style = Typography.bodyLarge,
                            )
                            Spacer(modifier = Modifier)
                            Text(
                                text = "watcherCount ${state.data.watchersCount}",
                                style = Typography.bodyLarge,
                            )
                            Spacer(modifier = Modifier)
                            Text(
                                text = "forkCount: ${state.data.forksCount}",
                                style = Typography.bodyLarge,
                            )
                        }
                    }
                }
            }
        }
    }
}
