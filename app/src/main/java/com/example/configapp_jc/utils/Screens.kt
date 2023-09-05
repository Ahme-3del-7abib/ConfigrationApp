package com.example.configapp_jc.utils

import com.example.configapp_jc.utils.Constants.Companion.dashboardScreen

sealed class Screens(val route: String) {
    object DashboardScreen : Screens(dashboardScreen)
}
