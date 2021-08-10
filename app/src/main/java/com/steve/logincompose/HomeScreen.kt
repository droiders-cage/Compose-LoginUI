package com.steve.logincompose

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreen(var route: String,@StringRes val resourceId: Int,var icon:ImageVector) {
    object Home : HomeScreen("home", R.string.home,Icons.Default.Home)
    object Search : HomeScreen("search",R.string.search,Icons.Default.Search )
    object Library : HomeScreen("library", R.string.library,Icons.Default.Settings)
    object Notification : HomeScreen("notification", R.string.notifications,Icons.Default.Notifications)
    object Profile : HomeScreen("profile", R.string.profile,Icons.Default.Person)
}