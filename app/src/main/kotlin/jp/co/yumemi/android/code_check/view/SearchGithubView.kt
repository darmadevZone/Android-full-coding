package jp.co.yumemi.android.code_check.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.hilt.navigation.compose.hiltViewModel
import jp.co.yumemi.android.code_check.viewModel.SearchGithubViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchGithubView(viewModel: SearchGithubViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Android Engineer CodeCheck") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }) { inner ->
        Column(modifier = Modifier.padding(inner)) {
            OutlinedTextField(
                value = viewModel.query,
                onValueChange = { viewModel.query = it },
                maxLines = 1,
                placeholder = {
                    Text(text = "Github Search...")
                },
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardActions = KeyboardActions(onDone = { viewModel.searchGithubRepository() }),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
            val state = viewModel.state.value
            val ctx = LocalContext.current
            when {
                state.isLoading -> {
                    Log.d("Loading", state.isLoading.toString())
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                }

                !state.error.isNullOrBlank() -> {
                    Toast.makeText(ctx, state.error, Toast.LENGTH_LONG).show()
                }

                else -> {
                    LazyColumn {
                        items(state.data) {
                            Text(text = it.name)
                        }
                    }
                }
            }


        }
    }
}


