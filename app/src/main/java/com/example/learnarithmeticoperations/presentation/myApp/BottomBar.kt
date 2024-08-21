package com.example.learnarithmeticoperations.presentation.myApp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.learnarithmeticoperations.navigation.Screen

val listOfScreen = listOf(
    Pair(Screen.ProfileScreen, Icons.Rounded.Person),
    Pair(Screen.OrderScreen, Icons.Rounded.Shield),
    Pair(Screen.CompetitionScreen, Icons.Rounded.SportsMartialArts),
    Pair(Screen.SavedQuestionScreen, Icons.Rounded.Bookmark),
    Pair(Screen.LearningMapScreen, Icons.Rounded.Calculate),
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
                },
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        if(currentDestination?.hierarchy?.any { it.route == screen.first.route } == true) {
                            MaterialTheme.colorScheme.primary
                        }else {
                            Color.Transparent
                        },
                        RoundedCornerShape(10.dp)
                    )
                    .border(
                        BorderStroke(
                            4.dp,
                            if(currentDestination?.hierarchy?.any { it.route == screen.first.route } == true) {
                                MaterialTheme.colorScheme.onPrimary
                            }else {
                                Color.Transparent
                            },
                        ),
                        RoundedCornerShape(10.dp)
                    )
            )
        }
    }
}