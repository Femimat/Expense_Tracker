package com.example.expensetracker.ui.screen

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getCurrentDateRange(): String {
    val now = LocalDate.now()
    val firstDay = now.withDayOfMonth(1)
    val lastDay = now.withDayOfMonth(now.lengthOfMonth())
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return "${firstDay.format(formatter)} ~ ${lastDay.format(formatter)}"
}