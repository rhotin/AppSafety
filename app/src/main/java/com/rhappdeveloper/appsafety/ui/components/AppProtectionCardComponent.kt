package com.rhappdeveloper.appsafety.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppProtectionCardComponent() {
    Card(
        modifier = Modifier
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row {
            Text(
                modifier = Modifier.padding(5.dp),
                text = "App protection"
            )
            Text(
                modifier = Modifier.padding(top = 5.dp, end = 5.dp, bottom = 5.dp),
                text = "ENABLED",
                color = Color.Blue
            )
        }

    }
}