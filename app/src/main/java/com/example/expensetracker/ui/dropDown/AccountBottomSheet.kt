package com.example.expensetracker.ui.dropDown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.model.Accounts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountBottomSheet(
    selectedAccount: String,
    onAccountSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val account = listOf(
        Accounts("Cash", "🍔"),
        Accounts("Accounts", "🎭"),
        Accounts("Card", "🐾"),
    )

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.surface,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Accounts",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Row {
                    IconButton(onClick = { /* Handle edit */ }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Account Grid
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                // Row 1
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    AccountItem(
                        account = account[0],
                        isSelected = selectedAccount == account[0].name,
                        onClick = {
                            onAccountSelected(account[0].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    AccountItem(
                        account = account[1],
                        isSelected = selectedAccount == account[1].name,
                        onClick = {
                            onAccountSelected(account[1].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    AccountItem(
                        account = account[2],
                        isSelected = selectedAccount == account[2].name,
                        onClick = {
                            onAccountSelected(account[2].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
