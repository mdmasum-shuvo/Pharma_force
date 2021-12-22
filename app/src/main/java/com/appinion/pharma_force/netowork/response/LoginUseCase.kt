package com.appinion.pharma_force.netowork.response

import com.appinion.pharma_force.base.ResponseResult
import com.appinion.pharma_force.model.remot.auth.LoginResponse
import com.appinion.pharma_force.netowork.repository_callback.AuthRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(userId: String, password: String): Flow<ResponseResult<LoginResponse>> = flow {
        try {
            emit(ResponseResult.Loading())
            val loginResponse = repository.loginAuth(userId = userId, pass = password)
            emit(ResponseResult.Success(loginResponse))
        } catch (e: HttpException) {
            val error = ResponseResult.Error<LoginResponse>(e.localizedMessage ?: "An unexpected error")
            emit(error)
        } catch (e: IOException) {
            val error =
                ResponseResult.Error<LoginResponse>("Couldn't reach server. Check your internet connection.")
            emit(error)
        }
    }
}