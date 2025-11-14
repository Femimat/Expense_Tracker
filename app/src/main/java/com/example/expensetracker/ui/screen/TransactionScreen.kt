package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.ui.theme.getTextPrimaryColor
import com.example.expensetracker.ui.theme.getTextSecondaryColor
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionScreen(transactions: List<Transaction>, onAddClick: () -> Unit) {
    val income = transactions.filter {it.type == "Income" }.sumOf { it.amount }
    val expense = transactions.filter { it.type == "Expense" }.sumOf { it.amount }
    val total = income - expense
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    val textPrimary = getTextPrimaryColor()
    val textSecondary = getTextSecondaryColor()
    
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Daily", "Calendar", "Monthly", "Total", "Note")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Previous",
                        tint = textPrimary
                    )
                }
                Text(
                    text = "Nov 2025",
                    style = MaterialTheme.typography.titleMedium,
                    color = textPrimary,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = { /* Next month */ }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next",
                        tint = textPrimary
                    )
                }
            }

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                text = title,
                                color = if (selectedTab == index)
                                    MaterialTheme.colorScheme.primary
                                else
                                    textSecondary
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            SummaryHeader(
                income = income,
                expense = expense,
                total = total,
                currency = currency,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )

            Spacer(Modifier.height(16.dp))

            LazyColumn {
                items(transactions) { tx ->
                    ExpenseCard(expense = tx)
                }
            }
        }

        FloatingActionButton(
            onClick = onAddClick,
            containerColor = Color(0xFFFF6E6E),
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, "Add button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionScreen() {
    val sampleTransactions = listOf(
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),

        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Income",
            category = "💰 Salary",
            amount = 5500.0,
            account = "Card",
            note = "Monthly salary"
        ),
        Transaction(
            type = "Expense",
            category = "🍲 Food",
            amount = 1200.0,
            account = "Wallet",
            note = "Groceries & dining"
        )
    )

    TransactionScreen(transactions = sampleTransactions, onAddClick = {})
}

