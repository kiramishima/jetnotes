package net.kiramishima.app.jetnotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import net.kiramishima.app.jetnotes.routing.JetNotesRouter
import net.kiramishima.app.jetnotes.routing.Screen
import net.kiramishima.app.jetnotes.theme.JetNotesTheme
import net.kiramishima.app.jetnotes.ui.screens.NotesScreen
import net.kiramishima.app.jetnotes.ui.screens.SaveNoteScreen
// import net.kiramishima.app.jetnotes.ui.screens.SaveNoteScreen
// import net.kiramishima.app.jetnotes.ui.screens.TrashScreen
import net.kiramishima.app.jetnotes.viewmodel.MainViewModel
import net.kiramishima.app.jetnotes.viewmodel.MainViewModelFactory

/**
 * Main activity for the app.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as JetNotesApplication).dependencyInjector.repository
        )
    })

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityScreen(viewModel = viewModel)
        }
    }
}

@Composable
@ExperimentalMaterialApi
private fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (JetNotesRouter.currentScreen) {
            is Screen.Notes -> NotesScreen(viewModel)
            is Screen.SaveNote -> SaveNoteScreen(viewModel)
            // is Screen.Trash -> TrashScreen(viewModel)
        }
    }
}