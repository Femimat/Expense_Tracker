package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Transaction
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ExpenseCard(expense: Transaction) {
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    Card(Modifier.fillMaxWidth().padding(8.dp)) {
        Column(Modifier.padding(12.dp)) {
            Text("${expense.category} (${expense.type})")
            Text("Amount: ${currency.format(expense.amount)}")
            Text("Account: ${expense.account}")
            if (expense.note.isNotEmpty()) {
                Text("Note: ${expense.note}")
            }
        }
    }
}

@Preview
@Composable
fun PreviewExpenseCard() {
    val expense = Transaction(
        type = "Income",
        category = "💰 Salary",
        amount = 5500.0,
        account = "Card",
        note = "Monthly salary"
    )

    ExpenseCard(expense = expense)
}