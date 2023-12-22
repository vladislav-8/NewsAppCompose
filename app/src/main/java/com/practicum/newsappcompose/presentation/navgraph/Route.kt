package com.practicum.newsappcompose.presentation.navgraph

sealed class Route(
    val route: String
) {

    data object AppStartNavigation: Route(route = "appStartNavigation")
    data object OnBoardingScreen: Route(route = "onBoardingScreen")

    data object NewsNavigation: Route(route = "newsNavigation")
    data object NewsNavigatorScreen: Route(route = "newsNavigatorScreen")

    data object HomeScreen: Route(route = "homeScreen")
    data object SearchScreen: Route(route = "searchScreen")
    data object BookMarkScreen: Route(route = "bookMarkScreen")
    data object DetailsScreen: Route(route = "detailsScreen")
}
