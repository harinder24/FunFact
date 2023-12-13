package com.example.funfact.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {
var uiState = mutableStateOf(UserInputScreenState())
    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }
}

data class UserInputScreenState(
    var nameEntered : String = "",
    var animalSelected : String = ""
)

sealed class UserDataUiEvents{
    data class  UserNameEntered(val name:String): UserDataUiEvents()
    data class  AnimalSelected(val animalValue:String): UserDataUiEvents()
}