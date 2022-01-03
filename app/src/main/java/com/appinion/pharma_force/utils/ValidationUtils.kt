package com.appinion.pharma_force.utils

import androidx.compose.runtime.Composable
import com.appinion.pharma_force.ui.CustomSnackbar
import com.appinion.pharma_force.ui.theme.Red

data class Validation(val title: String, val data: String)

object ValidationUtils {
    var list = ArrayList<Validation>()

    fun clearValidationArray() {
        if (list.isNotEmpty())
            list.clear()
    }

    fun addValidation(data: Validation) {
        if (list.isNotEmpty()) {
            for (item in list) {
                if (item.title != data.title) {
                    list.add(data)
                }
            }
        } else
            list.add(data)
    }

    @Composable
    fun checkValidation(): Boolean {
        for (item in list) {
            if (item.data == "") {
                CustomSnackbar(
                    color = Red,
                    text = item.title + VALIDATION_MESSAGE
                )
                return false
            }
        }
        return true
    }
}

const val VALIDATION_MESSAGE = " can't be empty"