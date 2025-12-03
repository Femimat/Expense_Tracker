package com.example.expensetracker.model

data class Transaction (
    val id: String = java.util.UUID.randomUUID().toString(),
    val type: String,
    val category: String,
    val amount: Double,
    val account: String,
    val note: String = "",
    val date: String? = java.time.LocalDate.now().toString()
)

