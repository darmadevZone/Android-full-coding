package jp.co.yumemi.android.code_check.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jp.co.yumemi.android.code_check.ui.theme.Typography

@Composable
fun GithubDetailView(goToSearchView: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://i0.wp.com/theboreddev.com/wp-content/uploads/2021/10/kotlin_front.png?w=800&ssl=1",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "name", style = Typography.bodyLarge)
            Text(text = "written in language", style = Typography.bodyLarge)
            Text(text = "star count", style = Typography.bodyLarge)
            Text(text = "watcherCount", style = Typography.bodyLarge)
            Text(text = "forkCount", style = Typography.bodyLarge)
            Text(text = "owner")
        }
    }
}

/**
 *
val name: String,
val forksCount: Int?,
val openIssuesCount: Int,
val language: String?,
val stargazersCount: Int?,
val watchersCount: Int?,
val owner: Owner,
 */
