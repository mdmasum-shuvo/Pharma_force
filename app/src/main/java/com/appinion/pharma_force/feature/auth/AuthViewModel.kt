package com.appinion.pharma_force.feature.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appinion.pharma_force.base.ResponseResult
import com.appinion.pharma_force.base.UNEXPECTED_ERROR
import com.appinion.pharma_force.model.remot.auth.LoginResponse
import com.appinion.pharma_force.netowork.response.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state = _state

    private val _status = MutableLiveData<LoginResponse>()
    val status: LiveData<LoginResponse> = _status

    init {
        requestLogin("RF30528", "1039842")
    }

    fun requestLogin(userId: String, pass: String) {
        loginUseCase(userId = userId, password = pass).onEach { result ->

            when (result) {
                is ResponseResult.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
                is ResponseResult.Success -> {
                    _state.value = LoginState(data = result.data)
                }

                is ResponseResult.Error -> {
                    _state.value = LoginState(error = result.message ?: UNEXPECTED_ERROR)
                }

            }
        }.launchIn(viewModelScope)
    }
}