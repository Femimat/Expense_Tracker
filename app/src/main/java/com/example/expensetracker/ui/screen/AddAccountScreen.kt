package com.example.expensetracker.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.popUp.AccountPopupDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAccountScreen(
    selectedGroup: String?,
    onSave: (String, Double, String) -> Unit,
    onCancel: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var group by remember { mutableStateOf(selectedGroup) }
    var description by remember { mutableStateOf("") }
    var showPopup by remember { mutableStateOf(group == null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Account") },
                navigationIcon = {
                    IconButton(onCancel) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showPopup = true }
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Group",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.width(80.dp)
                )
                BasicTextField(
                    value = group ?: "",
                    onValueChange = { group = it },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.Gray,
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
                color = if (group.isNullOrEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Name",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.width(80.dp)
                )
                BasicTextField(
                    value = name,
                    onValueChange = { name = it },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.Gray,
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
                color = if (name.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(20.dp))

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
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.width(80.dp)
                )
                BasicTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.Gray,
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

            Spacer(modifier = Modifier.height(20.dp))
            // description Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Description",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.width(80.dp)
                )
                BasicTextField(
                    value = description,
                    onValueChange = { description = it },
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.Gray,
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
                color = if (description.isEmpty()) Color(0xFF3D3D3D) else Color(0xFFFF6E6E),
                thickness = 1.dp
            )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {
                    val balance = amount.toDoubleOrNull() ?: 0.0
                    onSave(name, balance, description)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6E6E)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Save", color = MaterialTheme.colorScheme.onPrimary)
            }
        }

        if (showPopup) {
            AccountPopupDialog(
                onDismiss = { showPopup = false },
                onGroupSelected = {
                    group = it
                    showPopup = true
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddAccountScreenPreview() {
    AddAccountScreen(
        selectedGroup = null,
        onSave = { _, _, _ -> },
        onCancel = {}
    )
}



