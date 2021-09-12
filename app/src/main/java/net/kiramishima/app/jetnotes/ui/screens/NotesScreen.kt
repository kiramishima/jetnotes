package net.kiramishima.app.jetnotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import net.kiramishima.app.jetnotes.domain.model.NoteModel
import net.kiramishima.app.jetnotes.ui.components.Note
import net.kiramishima.app.jetnotes.ui.components.TopAppBar
import net.kiramishima.app.jetnotes.viewmodel.MainViewModel

@Composable
fun NotesScreen(viewModel: MainViewModel) {
    val notes: List<NoteModel> by viewModel
        .notesNotInTrash
        .observeAsState(listOf())

    Column {
        TopAppBar(
            title = "JetNotes",
            icon = Icons.Filled.List,
            onIconClick = {}
        )
        LazyColumn {
            items(count = notes.size) { noteIndex ->
                val note = notes[noteIndex]
                Note(
                   note = note,
                   onNoteClick = {
                       viewModel.onNoteClick(it)
                   },
                   onNoteCheckedChange = {
                       viewModel.onNoteCheckedChange(it)
                   }
                )
            }
        }
    }
}

@Composable
private fun NotesList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) -> Unit,
    onNoteClick: (NoteModel) -> Unit
) {
    LazyColumn {
        items(count = notes.size) { noteIndex ->
            val note = notes[noteIndex]
            Note(
                note = note,
                onNoteClick = onNoteClick,
                onNoteCheckedChange = onNoteCheckedChange
            )
        }
    }
}

@Preview
@Composable
private fun NotesListPreview() {
    NotesList(
        notes = listOf(
            NoteModel(1, "Note 1", "Content 1", null),
            NoteModel(2, "Note 2", "Content 2", false),
            NoteModel(3, "Note 3", "Content 3", true)
        ),
        onNoteCheckedChange = {},
        onNoteClick = {}
    )
}