package com.example.myimmo2.data.repository

import com.example.myimmo2.data.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

class AuthRepository {

    suspend fun signUp(email: String, password: String) {
        SupabaseClient.client.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }

    suspend fun signIn(email: String, password: String) {
        SupabaseClient.client.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    fun signOut() {
        SupabaseClient.client.auth.signOut()
    }

    fun getCurrentUser() = SupabaseClient.client.auth.currentUserOrNull()
}
