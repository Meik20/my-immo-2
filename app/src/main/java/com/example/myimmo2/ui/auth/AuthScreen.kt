package com.example.myimmo2.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myimmo2.R

@Composable
fun AuthScreen(authViewModel: AuthViewModel = viewModel()) {

    val email by authViewModel.email.collectAsState()
    val password by authViewModel.password.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { authViewModel.onEmailChange(it) },
            label = { Text("Email") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { authViewModel.onPasswordChange(it) },
            label = { Text("Password") }
        )

        Button(onClick = { authViewModel.signIn() }) {
            Text("Sign In")
        }

        Button(onClick = { authViewModel.signUp() }) {
            Text("Sign Up")
        }
    }
}
