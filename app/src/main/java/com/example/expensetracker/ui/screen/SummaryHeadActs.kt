package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensetracker.ui.theme.getTextPrimaryColor
import com.example.expensetracker.ui.theme.getTextSecondaryColor
import java.text.NumberFormat
import java.util.Locale

@Composable
fun SummaryHeadActs(
    assets: Double,
    liabilities: Double,
    total: Double,
    currency: NumberFormat
) {

    val textPrimary = getTextPrimaryColor()
    val textSecondary = getTextSecondaryColor()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                "Assets",
                color = textSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                currency.format(assets),
                color = Color(0xFF2196F3),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                "Liabilities",
                color = textSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                currency.format(liabilities),
                color = Color(0xFFF44336),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                "Total",
                color = textSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                currency.format(total),
                color = textPrimary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall
            )
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
        total = 5200.0,
        currency = currency
    )
}