package net.kiramishima.app.jetnotes.viewmodel

import androidx.lifecycle.ViewModel
import net.kiramishima.app.jetnotes.data.repository.Repository

/**
 * View model used for storing the global app state.
 *
 * This view model is used for all screens.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {

}
