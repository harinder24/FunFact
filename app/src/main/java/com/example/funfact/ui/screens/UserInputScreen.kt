package com.example.funfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.funfact.R
import com.example.funfact.ui.AnimalCard
import com.example.funfact.ui.ButtonComponent
import com.example.funfact.ui.TextComponent
import com.example.funfact.ui.TextFieldComponent
import com.example.funfact.ui.TopBar
import com.example.funfact.ui.UserDataUiEvents
import com.example.funfact.ui.UserInputViewModel


@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen : (valuesPair: Pair<String,String>) -> Unit){
    Surface(modifier = Modifier.fillMaxSize()){
      Column (modifier = Modifier
          .fillMaxSize()
          .padding(18.dp)){
          TopBar(value = "Hi there \uD83D\uDE0A")
          TextComponent(textValue = "Let's learn about You !", textSize = 24.sp)
          Spacer(modifier = Modifier.size(20.dp))
          TextComponent(textValue = "This app will prepare a detail page based on input provided by you!", textSize = 18.sp)
          Spacer(modifier = Modifier.size(60.dp))
          TextComponent(textValue = "Name", textSize = 18.sp)
          Spacer(modifier = Modifier.size(10.dp))
          TextFieldComponent(onTextChange = {
              userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
          })
          Spacer(modifier = Modifier.size(20.dp))
          TextComponent(textValue = "What do you like", textSize = 18.sp)
          Row (modifier = Modifier.fillMaxWidth()){
            AnimalCard(image = R.drawable.f_cat2, animalSelected = {
                userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
            }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
              AnimalCard(image = R.drawable.f_dog, animalSelected = {
                  userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
              },selected = userInputViewModel.uiState.value.animalSelected == "Dog")
          }
          Spacer(modifier = Modifier.weight(1f))
          if(!userInputViewModel.uiState.value.nameEntered.isNullOrEmpty() && !userInputViewModel.uiState.value.animalSelected.isNullOrEmpty()){

              ButtonComponent(goToDetailsScreen = {
                    println("====coming====")
                  println("${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                  showWelcomeScreen(
                      Pair(
                          userInputViewModel.uiState.value.nameEntered,
                          userInputViewModel.uiState.value.animalSelected
                      )
                  )
              })
          }

      }
    }


}
