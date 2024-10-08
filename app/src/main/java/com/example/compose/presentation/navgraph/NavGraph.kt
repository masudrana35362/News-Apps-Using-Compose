package com.example.compose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.compose.presentation.bookmark.BookmarkScreen
import com.example.compose.presentation.bookmark.BookmarkViewModel
import com.example.compose.presentation.onboarding.OnBoardingScreen
import com.example.compose.presentation.onboarding.OnBoardingViewModel
import com.example.compose.presentation.search.SearchScreen
import com.example.compose.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(
                Route.NewsNavigatorScreen.route
            ) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value,  navigate = {})
            }
        }

    }
}