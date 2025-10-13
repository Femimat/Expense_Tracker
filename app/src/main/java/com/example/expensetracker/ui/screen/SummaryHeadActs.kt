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
fun SummaryHeadActs(
    assets: Double,
    liabilities: Double,
    balance: Double,
    currency: NumberFormat
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Assets", color = MaterialTheme.colorScheme.primary)
            Text(currency.format(assets), color = Color.Blue)
        }
        Column {
            Text("Liabilities", color = MaterialTheme.colorScheme.primary)
            Text(currency.format(liabilities), color = Color.Red)
        }
        Column {
            Text("Balance", fontWeight = FontWeight.Bold)
            Text(currency.format(balance))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SummaryHeadActsPreview() {
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    SummaryHeadActs(
        assets = 7500.0,
        liabilities = 3300.0,
        balance = 5200.0,
        currency = currency
    )
}