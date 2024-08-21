package com.example.learnarithmeticoperations.presentation.myApp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material.icons.rounded.SportsMartialArts
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.learnarithmeticoperations.navigation.Screen

val listOfScreen = listOf(
    Pair(Screen.ProfileScreen, Icons.Rounded.Person),
    Pair(Screen.LearningMapScreen, Icons.Rounded.Calculate),
    Pair(Screen.SavedQuestionScreen, Icons.Rounded.Bookmark),
    Pair(Screen.CompetitionScreen, Icons.Rounded.SportsMartialArts),
    Pair(Screen.OrderScreen, Icons.Rounded.Shield),
)

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        listOfScreen.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.second, contentDescription = null) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.first.route } == true,
                onClick = {
                    navController.navigate(screen.first.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}