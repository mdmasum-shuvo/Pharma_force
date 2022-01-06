package com.appinion.pharma_force.feature.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.appinion.pharma_force.base.ResponseResult
import com.appinion.pharma_force.base.UNEXPECTED_ERROR
import com.appinion.pharma_force.base.VALIDATION_MESSAGE
import com.appinion.pharma_force.model.remot.auth.LoginData
import com.appinion.pharma_force.model.remot.auth.LoginResponse
import com.appinion.pharma_force.netowork.api_usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state = _state


    private val _validationMessage = mutableStateOf(ValidationState())
    val validationMessage = _validationMessage

    /*   init {
           requestLogin("RF30528", "1039842")
       }*/

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


    fun loginValidation(loginData: LoginData) {
        _validationMessage.value = ValidationState(userName = "",password = "")
        if (loginData.userId == "") {
            _validationMessage.value = ValidationState(userName = "User Id$VALIDATION_MESSAGE")
          //_validationMessage.value = ValidationState(userName = "")

            return
        } else if (loginData.password == "") {
            _validationMessage.value = ValidationState(password = "Password$VALIDATION_MESSAGE")
           // _validationMessage.value = ValidationState(password = "")
            return
        }
    }
}