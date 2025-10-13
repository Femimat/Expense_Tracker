package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import java.text.NumberFormat
import java.util.Locale

@Composable
fun SummaryHeader(
    income: Double,
    expense: Double,
    balance: Double,
    currency: NumberFormat
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Income", color = MaterialTheme.colorScheme.primary)
            Text(currency.format(income), color = Color.Blue)
        }
        Column {
            Text("Expenses", color = MaterialTheme.colorScheme.primary)
            Text(currency.format(expense), color = Color.Red)
        }
        Column {
            Text("Balance", fontWeight = FontWeight.Bold)
            Text(currency.format(balance))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SummaryHeaderPreview() {
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    SummaryHeader(
        income = 5500.0,
        expense = 2300.0,
        balance = 3200.0,
        currency = currency
    )
}