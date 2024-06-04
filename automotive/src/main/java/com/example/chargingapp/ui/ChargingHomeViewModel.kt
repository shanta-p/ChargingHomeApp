package com.example.chargingapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * Created by shanta on 3/6/24
 */
class ChargingHomeViewModel(): ViewModel() {

    val uiState by mutableStateOf(
        ChargingHomeUIState(
            isCharging = false,
            isHatchOpen = false,
            isCableConnected = false,
            chargeLevel = 0,
            shouldStartCharging = false
        ))
}

data class ChargingHomeUIState(
    val isHatchOpen: Boolean,
    val isCableConnected: Boolean,
    val isCharging: Boolean,
    val chargeLevel: Int,
    val shouldStartCharging: Boolean
)