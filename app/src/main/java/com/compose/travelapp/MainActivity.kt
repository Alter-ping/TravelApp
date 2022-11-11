package com.compose.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.travelapp.home_screen.HomeScreen
import com.compose.travelapp.login_screen.LoginScreen
import com.compose.travelapp.login_screen.LoginScreenViewModel
import com.compose.travelapp.ui.theme.GoogleAuthTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleAuthTheme {
                LoginUi()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun LoginUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_screen", builder = {
        composable("login_screen", content = { LoginScreen(navController = navController) })
        composable("register_screen", content = { })
        composable("home_screen", content =  { HomeScreen(navController = navController) })
    })
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ComposeUiPreview() {
    GoogleAuthTheme {
        val navController = rememberNavController()
        Surface {
            LoginScreen(navController = navController, viewModel = LoginScreenViewModel())
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ComposeUiDarkPreview() {
    GoogleAuthTheme(darkTheme = true) {
        val navController = rememberNavController()
        Surface {
            LoginScreen(navController = navController, viewModel = LoginScreenViewModel())
        }
    }
}

