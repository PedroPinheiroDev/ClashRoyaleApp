package com.example.clashroyaleapplication.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<Events : Event, States : State> : ViewModel() {
    abstract val state: StateFlow<States>
    abstract fun onEvent(event : Events)
}