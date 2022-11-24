package com.compose.travelapp.login_screen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.compose.googleauth.R
import com.compose.travelapp.Screen
import com.compose.travelapp.Utils.LoadingState
import com.compose.travelapp.ui.theme.GoogleAuthTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
@ExperimentalMaterialApi
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginScreenViewModel = viewModel()) {

    val auth by lazy { FirebaseAuth.getInstance() }
    val status by viewModel.loadingState.collectAsState()
    val context = LocalContext.current
    val token = stringResource(R.string.default_web_client_id)
    var validation = false


    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            viewModel.signWithGoogleCredential(credential)
        } catch (e: ApiException) {
            Log.w("TAG", "Google sign in failed", e)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        Text(text = "Login", style = MaterialTheme.typography.h5)
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .border(
                    width = 1.dp,
                    Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                ),

            label = {
                Text("Email",fontSize = 12.sp)
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Email,
                    "EmailIcon"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor =  Color.White, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    Color.LightGray,
                    shape = RoundedCornerShape(8.dp)
                ),
            value = password,
            label = {
                Text("Password",fontSize = 12.sp)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    "LockIcon"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                backgroundColor = MaterialTheme.colors.background,
                focusedIndicatorColor =  Color.White, //hide the indicator
                unfocusedIndicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    navController.navigate(Screen.HomeScreen.route)
                    Log.i("User logged in","User logged in")
                } else {
                    Log.e("User failed to login", "User failed to login")
                }
            }
                         },
            content={
                Text(
                    text = "Login",color = Color.White)
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Or, login with"
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Surface(
                border = BorderStroke(1.dp, Color.DarkGray),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(token)
                        .requestEmail()
                        .build()

                    val googleSignInClient = GoogleSignIn.getClient(context, gso)
                    launcher.launch(googleSignInClient.signInIntent)

                    if (status.status == LoadingState.Status.SUCCESS){
                        validation = true
                   }
                    if(status.status == LoadingState.LOADED.status){
                        navController.navigate(Screen.HomeScreen.route)
                    }
                }
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.google
                    ),
                    contentDescription = "GoogleIcon",
                    modifier = Modifier
                        .padding(5.dp)
                        .width(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                border = BorderStroke(1.dp, Color.DarkGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "FacebookIcon",
                    modifier = Modifier
                        .padding(5.dp)
                        .width(40.dp)
                )

            }
//            Surface(
//                border = BorderStroke(1.dp, Color.DarkGray),
//                shape = RoundedCornerShape(5.dp)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.apple),
//                    contentDescription = "AppleIcon",
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .width(40.dp)
//                )
//
//            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(
                text = "New to Login? ",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Register",
                color = MaterialTheme.colors.primaryVariant
            )
        }
    }

    when (status.status) {
        LoadingState.Status.SUCCESS -> {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
        LoadingState.Status.FAILED -> {
            Toast.makeText(context, status.msg ?: "Error", Toast.LENGTH_SHORT).show()
        }
        else -> {}
    }
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



