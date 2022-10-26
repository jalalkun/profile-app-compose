package com.jalalkun.profileappcompose.widget

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties

@Composable
fun ErrorAlert(message: String, dismissAction: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            dismissAction()
        },
        title = {
            Text(
                text = "Error",
                style = MaterialTheme.typography.titleMedium
            )
        },
        text = {
            Text(
                text = message,
                style = MaterialTheme.typography.labelMedium
            )
        },
        confirmButton = {

        },
        dismissButton = {
            Button(
                onClick = {
                    dismissAction()
                }) {
                Text(stringResource(id = android.R.string.ok))
            }
        },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
        shape = MaterialTheme.shapes.medium
    )
}
