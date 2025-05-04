package kotli.app.auth.common.data.repository

import kotli.app.auth.common.domain.model.AuthUser
import kotli.app.auth.common.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class StubAuthRepository : AuthRepository {

    private val authUserFlow = MutableStateFlow<AuthUser?>(null)

    override suspend fun getAuthUser(): Flow<AuthUser?> {
        return authUserFlow
    }

    override suspend fun signInWithGoogle() {
        val authUser = AuthUser(id = "1", email = "stub@gmail.com")
        authUserFlow.value = authUser
    }

    override suspend fun signInWithEmail(email: String) {
        authUserFlow.value = null
    }

    override suspend fun verifyEmail(email: String, otp: String) {
        val authUser = AuthUser(id = "1", email = email)
        authUserFlow.value = authUser
    }

    override suspend fun signOut() {
        authUserFlow.value = null
    }
}