package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.model.Account
import com.example.expensetracker.model.BottomDestination
import com.example.expensetracker.model.Transaction



@Preview(showBackground = true)
@Composable
fun BottomNavBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val sampleTransactions = listOf(
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
    )

    val sampleAccounts = listOf(
        Account("Savings", 5000.0, false),
        Account("Checking", 1200.0, false),
        Account("Credit Card", 800.0, true),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0),
        Account("Card", 10300.0)
    )

    Scaffold(
        bottomBar = {
            NavigationBar() {
                BottomDestination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(destination.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.label,
                                tint = if (currentRoute == destination.route) Color.Red else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                destination.label,
                                color = if (currentRoute == destination.route) Color.Red else Color.Gray
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomDestination.TRANSACTIONS.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomDestination.TRANSACTIONS.route) {
                TransactionScreen(transactions = sampleTransactions, onAddClick = { navController.navigate("addTransaction") })
            }

            composable(BottomDestination.STATS.route) { Text("Stats Screen") }

            composable(BottomDestination.ACCOUNTS.route) {
                AccountScreen(accounts = sampleAccounts, onAddClick = {navController.navigate("addAccount")}, onShowHideClick =  {}, onDeleteClick = {}, onModifyOrdersClick = {})
            }

            composable("addAccount") {
                AddAccountScreen(
                    selectedGroup = null, // start with no group
                    onSave = { name, balance, description ->
                        // save account logic here
                        navController.popBackStack()
                    },
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }

            composable("addTransaction") {
                AddTransactionScreen(
                    onSaveClick = { navController.popBackStack() },
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

    }
}

