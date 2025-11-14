package com.example.expensetracker.ui.popUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.expensetracker.ui.theme.getTextPrimaryColor

@Composable
fun AccountPopupDialog(
    onDismiss: () -> Unit,
    onGroupSelected: (String) -> Unit
) {

    val textPrimary = getTextPrimaryColor()
    val backgroundColor = MaterialTheme.colorScheme.surface

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Account Group",
                    style = MaterialTheme.typography.titleSmall,
                    color = textPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val groups = listOf(
                    "Cash",
                    "Accounts",
                    "Card",
                    "Debit Card",
                    "Savings",
                    "Top-Up/Prepaid",
                    "Investments",
                    "Overdrafts",
                    "Loan",
                    "Insurance",
                    "Others",
                )

                groups.forEach { group ->
                    Text(
                        text = group,
                        color = textPrimary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .clickable {
                                onGroupSelected(group)
                                onDismiss()
                            }
                    )
                }
            }
        }
    }
}