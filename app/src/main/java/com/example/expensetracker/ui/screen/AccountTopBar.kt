package com.example.expensetracker.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountTopBar(
    onAddClick: () -> Unit,
    onShowHideClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onModifyOrdersClick: () -> Unit
) {

    var menuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Accounts", fontSize = 18.sp) },
        actions = {
            IconButton(onClick = { menuExpanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Add") },
                    onClick = {
                        menuExpanded = false
                        onAddClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Show/Hide") },
                    onClick = {
                        menuExpanded = false
                        onShowHideClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Delete") },
                    onClick = {
                        menuExpanded = false
                        onDeleteClick()
                    }
                )
                DropdownMenuItem(
                    text = { Text("Modify Orders") },
                    onClick = {
                        menuExpanded = false
                        onModifyOrdersClick()
                    }
                )
            }
        }
    )
}

@Preview(showBackground  = true)
@Composable
fun AccountTopBarPreview() {
    AccountTopBar(
        onAddClick = {},
        onShowHideClick = {},
        onDeleteClick = {},
        onModifyOrdersClick = {}
    )
}
