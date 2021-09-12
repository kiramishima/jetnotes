package net.kiramishima.app.jetnotes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kiramishima.app.jetnotes.theme.rwGreen

@Composable
@Preview
fun Note() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(rwGreen)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Title", maxLines = 1)
            Text(text = "Content", maxLines = 1)
        }
        Checkbox(checked = false, onCheckedChange = {}, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
@Preview
private fun NotePreview() {
    Note()
}