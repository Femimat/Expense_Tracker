package com.example.expensetracker.calender

import com.example.expensetracker.model.MonthSummary
import com.example.expensetracker.model.Transaction
import java.time.YearMonth

fun getMonthSummaries(year: Int, transactions: List<Transaction>) : List<MonthSummary> {

    val summaries = mutableListOf<MonthSummary>()

    for (month in 1..12) {
        val yearMonth = YearMonth.of(year, month)
        val monthTransactions = transactions.filter { tx ->
            tx.date?.startsWith("$year-${String.format("%02d", month)}") == true
        }

        if (monthTransactions.isEmpty()) continue

        val income = monthTransactions.filter { it.type == "Income" }.sumOf { it.amount }
        val expense = monthTransactions.filter { it.type == "Expense" }.sumOf { it.amount }

        val weeklyBreakdown = getWeeklyBreakdown(yearMonth, monthTransactions)

        summaries.add(
            MonthSummary(
                month = yearMonth,
                income = income,
                expense = expense,
                weeklyBreakdown = weeklyBreakdown
            )
        )
    }
    return summaries
}
