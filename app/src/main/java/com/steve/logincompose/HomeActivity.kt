package com.steve.logincompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.steve.logincompose.ui.theme.LoginComposeTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                   MyNaviagtion()
                }
            }
        }
    }
}


@Composable
fun MyNaviagtion(){
    val items = listOf(
        HomeScreen.Home,
        HomeScreen.Search,
        HomeScreen.Library,
        HomeScreen.Notification,
        HomeScreen.Profile
    )

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = HomeScreen.Home.route, Modifier.padding(innerPadding)) {
            composable(HomeScreen.Home.route) { Home(navController) }
            composable(HomeScreen.Search.route) { Search(navController) }
            composable(HomeScreen.Library.route) {Library(navController) }
            composable(HomeScreen.Notification.route) { Notification(navController) }
            composable(HomeScreen.Profile.route) { Profile(navController) }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Column {
        Text(text = "Hellow home")
    }

}

@Composable
fun Search(navController: NavHostController) {

    Column {
        Text(text = "Hellow Search")
    }


}

@Composable
fun Library(navController: NavHostController) {
    Column {
        Text(text = "Hellow Library")
    }

}

@Composable
fun Notification(navController: NavHostController) {
    Column {
        Text(text = "Hellow notification")
    }

}

@Composable
fun Profile(navController: NavHostController) {
    Column {
        Text(text = "Hellow profile")
    }

}

@Preview
@Composable
fun PreviewMyNaviagtion(){

    LoginComposeTheme {
        MyNaviagtion()
    }

}

