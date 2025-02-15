package com.rhappdeveloper.appsafety.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rhappdeveloper.appsafety.R
import com.rhappdeveloper.appsafety.domain.model.Threat

@Composable
fun ThreatListComponent(threats: List<Threat>) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(threats) {
            ListItem(
                modifier = Modifier.clickable {
                    Toast.makeText(
                        context,
                        "Clicked: ${it.threat}, ${it.url_status}, ${it.url}",
                        Toast.LENGTH_LONG
                    ).show()
                },
                overlineContent = {},
                headlineContent = {
                    Text(
                        text = it.threat,
                        fontSize = 20.sp
                    )
                },
                supportingContent = {
                    Text(
                        text = it.urlhaus_reference,
                        fontSize = 15.sp
                    )
                },
                leadingContent = {
                    if (it.url_status.equals("online")) {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "arrow",
                            tint = Color.Red
                        )
                    } else if (it.url_status.equals("offline")) {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "arrow",
                            tint = colorResource(R.color.orange)
                        )
                    } else {
                        Icon(
                            Icons.Filled.Info,
                            contentDescription = "arrow",
                            tint = Color.Gray
                        )
                    }
                },
                trailingContent = {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "arrow"
                    )
                }
            )
        }
    }

}