package com.example.expensetracker.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

            OutlinedTextField(
                value = group ?: "",
                onValueChange = {},
                label = { Text("Group") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showPopup = true },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Red,
                    unfocusedLabelColor = Color.Gray
                )
            )

            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Red,
                    unfocusedLabelColor = Color.Gray,
                ),
            )

            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Red,
                    unfocusedLabelColor = Color.Gray,
                    focusedTextColor = Color.Cyan
                ),
            )

            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Red,
                    unfocusedLabelColor = Color.Gray
                ),
            )

            Spacer(Modifier.height(10.dp))

            Button(
                onClick = {
                    val balance = amount.toDoubleOrNull() ?: 0.0
                    onSave(name, balance, description)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Save", color = MaterialTheme.colorScheme.onPrimary)
            }
        }

        if (showPopup) {
            AccountPopupDialog(
                onDismiss = {  showPopup = false },
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



