package com.example.expensetracker.model

import androidx.compose.ui.graphics.Color

data class CategoryData(
    val name: String,
    val emoji: String,
    val amount: Double,
    val percentage: Double,
    val color: Color
)
