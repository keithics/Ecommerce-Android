package com.keithics.eteaap.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircularButtons(icon: ImageVector, description: String, onClick: () -> Unit) {
    IconButton(
        modifier = Modifier
            .background(
                MaterialTheme.colors.primary,
                shape = CircleShape
            )
            .size(25.dp)
            .padding(2.dp),
        onClick = onClick,
    ) {
        Icon(
            icon, description,
            tint = Color.White
        )
    }
}