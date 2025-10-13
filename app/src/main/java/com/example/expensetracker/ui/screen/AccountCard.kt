package com.example.expensetracker.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Account
import java.text.NumberFormat
import java.util.Locale

@Composable
fun AccountCard(account: Account) {
    val currency = NumberFormat.getCurrencyInstance(Locale.UK)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(3.dp)
    ) {
        Row(
            Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(account.name)
            Text(currency.format(account.balance))
        }
    }
}


@Preview
@Composable
fun PreviewAccountCard() {
    val sampleAccount = Account(
        name = "Savings",
        balance = 5000.0,
        isLiability = false
    )

    AccountCard(account = sampleAccount)
}

