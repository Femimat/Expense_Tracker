package com.example.expensetracker.model

import java.time.YearMonth

data class MonthSummary(
    val month: YearMonth,
    val income: Double,
    val expense: Double,
    val weeklyBreakdown: List<WeekSummary>
)
