package com.example.expensetracker.model

data class Transaction (
    val type: String,
    val category: String,
    val amount: Double,
    val account: String,
    val note: String = ""
)

