package com.example.expensetracker.calender

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.ui.theme.getTextSecondaryColor
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalenderView(
    yearMonth: YearMonth,
    transactions: List<Transaction>,
    modifier: Modifier = Modifier
) {
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstDayOfMonth = yearMonth.atDay(1)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
    val textSecondary = getTextSecondaryColor()

    Column(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = textSecondary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(firstDayOfWeek) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(0.5.dp, Color.Gray.copy(alpha = 0.3f))
                )
            }

            items(daysInMonth) { day ->
                val date = yearMonth.atDay(day + 1)
                val dayTransactions = transactions.filter {
                    it.date == date.toString()
                }

                val dayIncome = dayTransactions
                    .filter { it.type == "Income" }
                    .sumOf { it.amount }

                val dayExpense = dayTransactions
                    .filter { it.type == "Expense" }
                    .sumOf { it.amount }

                CalendarDayCell(
                    day = day + 1,
                    income = dayIncome,
                    expense = dayExpense,
                    isToday = date == LocalDate.now()
                )
            }
        }
    }
}