package inialdan.com.dzikirpagipetang.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import inialdan.com.dzikirpagipetang.R

@Composable
fun CustomToolbar(title: String) {
    val showDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(top = 36.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp)
                    .align(Alignment.CenterVertically),
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(21.dp)
                    .clickable {
                        showDialog.value = true
                    }
                    .align(Alignment.CenterVertically)
            )

        }
        // AlertDialog
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                title = {
                    Text(
                        text = "Tentang Aplikasi",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                text = {
                    Column {
                        Text("1. Rumaysho - Bacaan Dzikir Pagi")
                        Text("2. Rumyasho - Bacaan Dzikir Petang")
                        Text("3. Yazid bin Abdul Qadir Jawas\n    Dzikir Pagi Petang dan Sesudah Shalat\n    Fardhu (2017) - Pustaka Imam Asy-Syafii")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(text = "Mengerti")
                    }
                }
            )
        }
    }
}
