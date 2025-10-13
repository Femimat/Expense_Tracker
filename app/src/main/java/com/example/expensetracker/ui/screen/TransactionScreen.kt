package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Transaction
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionScreen(transactions: List<Transaction>, onAddClick: () -> Unit) {
    val income = transactions.filter {it.type == "Income" }.sumOf { it.amount }
    val expense = transactions.filter { it.type == "Expense" }.sumOf { it.amount }
    val balance = income - expense
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SummaryHeader(
                income = income,
                expense = expense,
                balance = balance,
                currency = currency
            )

            Spacer(Modifier.height(16.dp))

            LazyColumn {
                items(transactions) { tx ->
                    ExpenseCard(expense = tx)
                }
            }
        }

        FloatingActionButton(
            onClick = onAddClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionScreen() {
    val sampleTransactions = listOf(
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),

        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Expense",
            category = "🍲 Food",
            amount = 1200.0,
            account = "Wallet",
            note = "Groceries & dining"
        )
    )

    TransactionScreen(transactions = sampleTransactions, onAddClick = {})
}

