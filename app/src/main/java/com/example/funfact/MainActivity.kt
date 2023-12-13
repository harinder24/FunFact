package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.funfact.ui.screens.FunFactNavigationGraph
import com.example.funfact.ui.screens.Routes
import com.example.funfact.ui.screens.UserInputScreen
import com.example.funfact.ui.screens.WelcomeScreen
import com.example.funfact.ui.theme.FunFactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunFactTheme {
                FunFactApp()
            }
        }
    }
}

@Composable
fun FunFactApp(){
    FunFactNavigationGraph()
}