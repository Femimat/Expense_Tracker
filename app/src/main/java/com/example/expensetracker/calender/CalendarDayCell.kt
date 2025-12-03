package com.example.expensetracker.calender

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarDayCell(
    day: Int,
    income: Double,
    expense: Double,
    isToday: Boolean
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .border(0.5.dp, Color.Gray.copy(alpha = 0.3f))
            .background(if (isToday) Color.Gray.copy(alpha = 0.2f) else Color.Transparent)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = day.toString(),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Medium
            )

            if (expense > 0) {
                Text(
                    text = "-£%.2f".format(expense),
                    fontSize = 9.sp,
                    color = Color(0xFFFF6E6E),
                    maxLines = 1
                )
            }

            if (income > 0) {
                Text(
                    text = "-£%.2f".format(income),
                    fontSize = 9.sp,
                    color = Color(0xFF4ECDC4),
                    maxLines = 1
                )
            }
        }
    }
}