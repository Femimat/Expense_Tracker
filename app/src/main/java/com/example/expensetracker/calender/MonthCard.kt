package com.example.expensetracker.calender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.model.MonthSummary
import java.time.format.DateTimeFormatter

@Composable
fun MonthCard(summary: MonthSummary) {

    val monthName = summary.month.format(DateTimeFormatter.ofPattern("MMM"))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = monthName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "£ ${String.format("%.2f", summary.income)}",
                        fontSize = 14.sp,
                        color = Color(0xFF4ECDC4)
                    )
                    Text(
                        text = "£ ${String.format("%.2f", summary.expense)}",
                        fontSize = 14.sp,
                        color = Color(0xFFFF6E6E)
                    )
                    Text(
                        text = "£ ${String.format("%.2f", summary.income - summary.expense)}",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            if (summary.weeklyBreakdown.isNotEmpty()) {
                Spacer(Modifier.height(12.dp))

                summary.weeklyBreakdown.forEach { week ->
                    WeekRow(week = week)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }