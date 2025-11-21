package com.example.myimmo2.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myimmo2.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authRepository = AuthRepository()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun signUp() {
        viewModelScope.launch {
            try {
                authRepository.signUp(_email.value, _password.value)
                // Handle successful sign up, e.g., navigate to another screen
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun signIn() {
        viewModelScope.launch {
            try {
                authRepository.signIn(_email.value, _password.value)
                // Handle successful sign in
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
