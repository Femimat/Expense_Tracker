package com.example.expensetracker.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.ui.theme.getTextSecondaryColor

@SuppressLint("DefaultLocale")
@Composable
fun TotalView(
    transactions: List<Transaction>,
    modifier: Modifier = Modifier
) {
    val income = transactions.filter { it.type == "Income" }.sumOf { it.amount }
    val expense = transactions.filter { it.type == "Expense" }.sumOf { it.amount }
    val total = income - expense
    val textSecondary = getTextSecondaryColor()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2D2D2D)
                ),
                onClick = { }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.PieChart,
                            contentDescription = "Budget",
                            tint = Color.White
                        )
                        Text(
                            text = "Budget",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Budget Setting",
                            fontSize = 14.sp,
                            color = textSecondary
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Go",
                            tint = textSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2D2D2D)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBalance,
                            contentDescription = "Accounts",
                            tint = Color.White
                        )
                        Text(
                            text = "Accounts",
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = getCurrentDateRange(),
                        fontSize = 13.sp,
                        color = textSecondary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AccountStatRow(
                        label = "Compared Expenses (Last month)",
                        value = "100%",
                        valueColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AccountStatRow(
                        label = "Expenses (Cash, Accounts)",
                        value = "£ ${String.format("%.2f", expense)}",
                        valueColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AccountStatRow(
                        label = "Expenses (Card)",
                        value = "£ ${String.format("%.2f",
                            transactions.filter { 
                                it.type == "Expense" && it.account == "Card"
                            }.sumOf { it.amount }
                        )}",
                        valueColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AccountStatRow(
                        label = "Transfer (Cash, Accounts→)",
                        value = "£ 0.00",
                        valueColor = Color.White
                    )
                }
            }
        }

        item {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF2D2D2D),
                    contentColor = Color(0xFF4ECDC4)
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📊 Export data to Excel",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}