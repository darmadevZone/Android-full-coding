package jp.co.yumemi.android.code_check

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.ui.theme.YumemiCodeCheckTheme
import jp.co.yumemi.android.code_check.view.GithubDetailView
import jp.co.yumemi.android.code_check.view.SearchGithubView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YumemiCodeCheckTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ViewRoute.SearchGithubView.route,
                ) {
                    composable(route = ViewRoute.SearchGithubView.route) {
                        SearchGithubView(
                            goToDetailView = { it ->
                                navController.navigate(
                                    ViewRoute.GithubDetailView.route.replace(
                                        "{repositoryName}",
                                        it.name,
                                    ).replace("{owner}", it.owner.name),
                                )
                            },
                        )
                    }
                    composable(
                        route = ViewRoute.GithubDetailView.route,
                        arguments =
                        listOf(
                            navArgument("repositoryId") {
                                type = NavType.StringType
                            },
                            navArgument("owner") {
                                type = NavType.StringType
                            },
                        ),
                    ) { backStackEntry ->
                        GithubDetailView(
                            goToSearchView = { navController.navigate(ViewRoute.SearchGithubView.route) },
                            repositoryName = checkNotNull(backStackEntry.arguments?.getString("repositoryId")),
                            repositoryOwner = checkNotNull(backStackEntry.arguments?.getString("owner")),
                        )
                    }
                }
            }
        }
    }
}
