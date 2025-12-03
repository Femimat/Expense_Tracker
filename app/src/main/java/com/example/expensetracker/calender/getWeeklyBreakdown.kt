package com.example.expensetracker.calender

import com.example.expensetracker.model.Transaction
import com.example.expensetracker.model.WeekSummary
import java.lang.Exception
import java.time.LocalDate
import java.time.YearMonth

fun getWeeklyBreakdown(yearMonth: YearMonth, transactions: List<Transaction>) : List<WeekSummary> {

    val weeks = mutableListOf<WeekSummary>()

    val daysInMonth = yearMonth.lengthOfMonth()
    var currentWeekStart = 1

    while (currentWeekStart <= daysInMonth) {
        val startDate = yearMonth.atDay(currentWeekStart)
        var endDay = currentWeekStart + 6
        if (endDay > daysInMonth) endDay = daysInMonth
        val endDate = yearMonth.atDay(endDay)

        val weekTransactions = transactions.filter { tx ->
            try {
                val txDate = LocalDate.parse(tx.date)
                !txDate.isBefore(startDate) && !txDate.isAfter(endDate)
            } catch (e: Exception) {
                false
            }
        }

        val income = weekTransactions.filter { it.type == "Income" }.sumOf { it.amount }
        val expense = weekTransactions.filter { it.type == "Expense" }.sumOf { it.amount }

        if (income > 0 || expense > 0) {
            weeks.add(
                WeekSummary(
                    weekRange = "${String.format("%02d", currentWeekStart)}.${String.format("%02d", yearMonth.monthValue)} ~ ${String.format("%02d", endDay)}.${String.format("%02d", yearMonth.monthValue)}",
                    income = income,
                    expense = expense
                )
            )
        }
        currentWeekStart = endDay +1
    }
    return weeks
}