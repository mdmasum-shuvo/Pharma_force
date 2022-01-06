/*
 * *
 *  * Created by MD. Masum Talukder on 1/6/22, 11:18 AM
 *  * masum.talukder@appinionbd.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 1/6/22, 11:18 AM
 *
 */

package com.appinion.pharma_force.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appinion.pharma_force.model.remot.auth.LoginData
import javax.inject.Inject

class FormValidationViewModel @Inject constructor() : ViewModel() {
    companion object{
    }
    val loginData = MutableLiveData<LoginData>()
    val password = MutableLiveData<String>("")

    private val _validationMessage = MutableLiveData<String>()
    val validationMessage: LiveData<String>
        get() = _validationMessage
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(loginData) {
            val valid = isFormValid(it)
        }
    }

    private fun isFormValid(it: LoginData?): Boolean {
        if (it!!.userId == "") {
            _validationMessage.value= "User Id $VALIDATION_MESSAGE"
            return false
        }
        return true
    }
}


