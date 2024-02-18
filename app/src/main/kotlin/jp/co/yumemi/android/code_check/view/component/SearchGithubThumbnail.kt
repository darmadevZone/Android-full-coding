package jp.co.yumemi.android.code_check.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jp.co.yumemi.android.code_check.model.Item

@Composable
fun SearchGithubThubnail(
    item: Item,
    goToDetailView: (Item) -> Unit,
) {
    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp, max = 100.dp)
            .clickable {
                goToDetailView(item)
            },
    ) {
        Row {
            AsyncImage(
                model = item.owner.avatarUrl,
                contentDescription = "Image",
            )
            Column(
                modifier =
                Modifier.background(MaterialTheme.colorScheme.background)
                    .fillMaxSize().weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(text = "Language: ${item.name}")
                Text(text = "Watch Count: ${item.watchersCount}")
                Text(text = "Star Count: ${item.stargazersCount}")
            }
        }
    }
}
