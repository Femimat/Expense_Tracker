package com.example.expensetracker.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomDestination(val label: String, val route: String, val icon: ImageVector) {
    TRANSACTIONS("Trans.", "transactions", Icons.AutoMirrored.Filled.List),
    STATS("Stats", "stats", Icons.Default.BarChart),
    ACCOUNTS("Accounts", "accounts", Icons.Default.AccountCircle),
}