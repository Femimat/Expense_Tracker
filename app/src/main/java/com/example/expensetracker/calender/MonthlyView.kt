package com.example.expensetracker.calender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Transaction

@Composable
fun MonthlyView(
    year: Int,
    transactions: List<Transaction>,
) {
    val monthSummaries = getMonthSummaries(year, transactions)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(monthSummaries.reversed()) { summary ->
            MonthCard(summary = summary)
        }
    }
}

