package com.example.expensetracker.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.model.CategoryData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen() {
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = Income, 1 = Expenses
    var selectedPeriod by remember { mutableStateOf("Monthly") }
    var currentMonth by remember { mutableStateOf("Nov 2025") }
    var showPeriodMenu by remember { mutableStateOf(false) }

    // Sample data for Income
    val incomeData = listOf(
        CategoryData("Salary", "💰", 5500.00, 53.4, Color(0xFFFF6B6B)),
        CategoryData("Allowance", "🤑", 4800.00, 46.6, Color(0xFFFFB366))
    )

    // Sample data for Expenses
    val expenseData = listOf(
        CategoryData("Food", "👑", 5000.00, 100.0, Color(0xFFFF6B6B))
    )

    val currentData = if (selectedTab == 0) incomeData else expenseData
    val totalIncome = 10300.00
    val totalExpenses = 5000.00
    
    Scaffold(
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Header with Month Navigation
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Previous month */ } ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Previous",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = currentMonth,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                IconButton(onClick = { /* Next month */ } ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Box {
                    OutlinedButton(
                        onClick = { showPeriodMenu = true },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp)
                    ) {
                        Text(selectedPeriod, fontSize = 14.sp)
                    }

                    DropdownMenu(
                        expanded = showPeriodMenu,
                        onDismissRequest = { showPeriodMenu = false },
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.onSurfaceVariant)
                    ) {
                        listOf("Daily", "Weekly", "Monthly", "Yearly").forEach { period ->
                            DropdownMenuItem(
                                text = { Text(period, color = MaterialTheme.colorScheme.surface) },
                                onClick = {
                                    selectedPeriod = period
                                    showPeriodMenu = false
                                }
                            )
                        }
                    }
                }
            }

            // Income/Expenses Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    TextButton(
                        onClick = { selectedTab = 0 },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Income",
                                color = if (selectedTab == 0) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                                fontSize = 14.sp
                            )
                            Text(
                                text = "£ ${String.format("%.2f", totalIncome)}",
                                color = if (selectedTab == 0) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    if (selectedTab == 0) {
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    TextButton(
                        onClick = { selectedTab = 1 },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Expenses",
                                color = if (selectedTab == 1) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                                fontSize = 14.sp
                            )
                            Text(
                                text = "£ ${String.format("%.2f", totalExpenses)}",
                                color = if (selectedTab == 1) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    if (selectedTab == 1) {
                        HorizontalDivider(
                            thickness = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Pie Chart
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                PieChart(data = currentData)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Category List
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                currentData.forEach { category ->
                    CategoryItem(category = category)
                }
            }
        }
    }
}