package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Account
import java.text.NumberFormat
import java.util.Locale


@Composable
fun AccountScreen(
    accounts: List<Account>,
    onAddClick: () -> Unit,
    onShowHideClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onModifyOrdersClick: () -> Unit
) {
    val assets = accounts.filter { !it.isLiability }.sumOf { it.balance }
    val liabilities = accounts.filter { it.isLiability }.sumOf { it.balance }
    val balance = assets - liabilities
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    Scaffold(
        topBar = {
            AccountTopBar(
                onAddClick = onAddClick,
                onShowHideClick = onShowHideClick,
                onDeleteClick = onDeleteClick,
                onModifyOrdersClick = onModifyOrdersClick
            )
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(6.dp)
                .fillMaxSize()
        ) {

            SummaryHeadActs(
                assets = assets,
                liabilities = liabilities,
                balance = balance,
                currency = currency
            )

            Spacer(Modifier.height(10.dp))

            LazyColumn {
                items(accounts) { acc ->
                    AccountCard(account = acc)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    val sampleAccounts = listOf(
        Account("Cash", 0.0),
        Account("Accounts", 5000.0, isLiability = true),
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

    AccountScreen(accounts = sampleAccounts, onAddClick = {}, onShowHideClick =  {}, onDeleteClick = {}, onModifyOrdersClick = {})
}
