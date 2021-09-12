package net.kiramishima.app.jetnotes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import net.kiramishima.app.jetnotes.routing.Screen
import net.kiramishima.app.jetnotes.theme.JetNotesTheme
import net.kiramishima.app.jetnotes.ui.components.AppDrawer
import net.kiramishima.app.jetnotes.ui.components.Note
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetNotesTheme {
                val coroutineScope = rememberCoroutineScope()
                val scaffoldState : ScaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        AppDrawer(
                            currentScreen = Screen.Notes,
                            closeDrawerAction = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    },
                    content = {
                        Note()
                    }
                )
            }
        }
    }
}