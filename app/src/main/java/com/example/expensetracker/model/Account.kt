package com.example.expensetracker.model

 data class Account (
    val name: String,
    val balance: Double,
    val isLiability: Boolean = false
)
