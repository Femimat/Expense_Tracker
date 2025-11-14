package com.example.expensetracker.ui.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.dropDown.AccountBottomSheet
import com.example.expensetracker.ui.dropDown.CategoryBottomSheet
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ExpenseForm(onSaveClick: () -> Unit) {

    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy (EEE)", Locale.getDefault()) }
    val timeFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    val currentDate = remember { Date() }

    var date by remember { mutableStateOf(dateFormat.format(currentDate)) }
    var time by remember { mutableStateOf(timeFormat.format(currentDate)) }
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var account by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var showCategorySheet by remember { mutableStateOf(false) }
    var showAccountSheet by remember { mutableStateOf(false) }

    if (showCategorySheet) {
        CategoryBottomSheet(
            selectedCategory = category,
            onCategorySelected = { category = it },
            onDismiss = { showCategorySheet = false }
        )
    }

    if (showAccountSheet) {
        AccountBottomSheet(
            selectedAccount = account,
            onAccountSelected = { account = it },
            onDismiss = { showAccountSheet = false }
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        // Date Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Date",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp,
                modifier = Modifier.width(80.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = date,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 15.sp
                )
                Text(
                    text = time,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 15.sp
                )
                IconButton(
                    onClick = {
                        val newDate = Date()
                        date = dateFormat.format(newDate)
                        time = timeFormat.format(newDate)
                    },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh Date",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        HorizontalDivider(
            color = if (date.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        // Amount Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Amount",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp,
                modifier = Modifier.width(80.dp)
            )
            BasicTextField(
                value = amount,
                onValueChange = { amount = it },
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 15.sp
                ),
                modifier = Modifier.weight(1f),
                singleLine = true,
                cursorBrush = androidx.compose.ui.graphics.SolidColor(Color(0xFF4C9AFF)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        innerTextField()
                    }
                }
            )
        }
        HorizontalDivider(
            color = if (amount.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showCategorySheet = true }
                .padding(vertical = 12.dp),
            horizontalArrangement  = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Category",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp,
                modifier = Modifier.width(80.dp)
            )
            Text(
                text = category,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp
            )
        }
        HorizontalDivider(
            color = if (category.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        // Account Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showAccountSheet = true }
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Account",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp,
                modifier = Modifier.width(80.dp)
            )
            Text(
                text = account,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp
            )
        }
        HorizontalDivider(
            color = if (account.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        // Note Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Note",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 15.sp,
                modifier = Modifier.width(80.dp)
            )
            BasicTextField(
                value = note,
                onValueChange = { note = it },
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 15.sp
                ),
                modifier = Modifier.weight(1f),
                singleLine = true,
                cursorBrush = androidx.compose.ui.graphics.SolidColor(Color(0xFF4C9AFF)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        innerTextField()
                    }
                }
            )
        }
        HorizontalDivider(
            color = if (note.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Description Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = description,
                onValueChange = { description = it },
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 15.sp
                ),
                modifier = Modifier.weight(1f),
                singleLine = true,
                cursorBrush = androidx.compose.ui.graphics.SolidColor(Color(0xFF4C9AFF)),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        if (description.isEmpty()) {
                            Text(
                                text = "Description",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 15.sp
                            )
                        }
                        innerTextField()
                    }
                }
            )
            IconButton(
                onClick = { /* Handle camera */ },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Camera",
                    tint = Color.Gray,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
        HorizontalDivider(
            color = if (description.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Bottom Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onSaveClick,
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6E6E),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Save",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Button(
                onClick = { /* Handle continue */ },
                modifier = Modifier
                    .weight(0.5f)
                    .height(46.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2D2D2D),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}