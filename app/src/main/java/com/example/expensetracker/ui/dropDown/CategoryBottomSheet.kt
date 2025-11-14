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
import com.example.expensetracker.model.Category


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryBottomSheet(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val categories = listOf(
        Category("Food", "🍔"),
        Category("Social Life", "🎭"),
        Category("Pets", "🐾"),
        Category("Transport", "🚗"),
        Category("Culture", "🏛️"),
        Category("Household", "🏠"),
        Category("Apparel", "👕"),
        Category("Beauty", "💄"),
        Category("Health", "🏥"),
        Category("Education", "📚"),
        Category("Gift", "🎁"),
        Category("Other", "")
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
                    text = "Category",
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

            // Category Grid
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                // Row 1
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    CategoryItem(
                        category = categories[0],
                        isSelected = selectedCategory == categories[0].name,
                        onClick = {
                            onCategorySelected(categories[0].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[1],
                        isSelected = selectedCategory == categories[1].name,
                        onClick = {
                            onCategorySelected(categories[1].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[2],
                        isSelected = selectedCategory == categories[2].name,
                        onClick = {
                            onCategorySelected(categories[2].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Row 2
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    CategoryItem(
                        category = categories[3],
                        isSelected = selectedCategory == categories[3].name,
                        onClick = {
                            onCategorySelected(categories[3].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[4],
                        isSelected = selectedCategory == categories[4].name,
                        onClick = {
                            onCategorySelected(categories[4].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[5],
                        isSelected = selectedCategory == categories[5].name,
                        onClick = {
                            onCategorySelected(categories[5].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Row 3
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    CategoryItem(
                        category = categories[6],
                        isSelected = selectedCategory == categories[6].name,
                        onClick = {
                            onCategorySelected(categories[6].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[7],
                        isSelected = selectedCategory == categories[7].name,
                        onClick = {
                            onCategorySelected(categories[7].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[8],
                        isSelected = selectedCategory == categories[8].name,
                        onClick = {
                            onCategorySelected(categories[8].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Row 4
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    CategoryItem(
                        category = categories[9],
                        isSelected = selectedCategory == categories[9].name,
                        onClick = {
                            onCategorySelected(categories[9].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[10],
                        isSelected = selectedCategory == categories[10].name,
                        onClick = {
                            onCategorySelected(categories[10].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                    CategoryItem(
                        category = categories[11],
                        isSelected = selectedCategory == categories[11].name,
                        onClick = {
                            onCategorySelected(categories[11].name)
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}