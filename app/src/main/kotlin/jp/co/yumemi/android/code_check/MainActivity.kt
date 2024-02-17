package jp.co.yumemi.android.code_check

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.ui.theme.YumemiCodeCheckTheme
import jp.co.yumemi.android.code_check.view.SearchGithubView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YumemiCodeCheckTheme {
                SearchGithubView()
            }
        }
    }
}
