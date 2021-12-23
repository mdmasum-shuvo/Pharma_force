package com.appinion.pharma_force.feature.auth.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appinion.pharma_force.R
import com.appinion.pharma_force.feature.auth.AuthViewModel
import com.appinion.pharma_force.ui.component.ImageNormal
import com.appinion.pharma_force.ui.component.CustomSpacerHeight
import com.appinion.pharma_force.ui.theme.*

@SuppressLint("RememberReturnType")
@Composable
fun LoginUiComponent(viewmodel: AuthViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val textStateUserId = remember { mutableStateOf("") }
    val textStatePassword = remember { mutableStateOf("") }
    var passwordVisibility = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSpacerHeight(size = 96)
        ImageNormal(drawableId = R.drawable.app_icon, 84, 120)
        CustomSpacerHeight(size = 12)
        CustomTextHeader(
            text = context.getString(R.string.app_name),
            textStyle = MaterialTheme.typography.h3
        )
        CustomTextHeader(
            text = context.getString(R.string.by_company_name),
            textStyle = MaterialTheme.typography.h4
        )
        CustomSpacerHeight(size = 92)
        CustomRoundTextField(context.getString(R.string.user_id), textStateUserId)
        CustomSpacerHeight(size = 16)
        CustomRoundTextField(context.getString(R.string.password), textStatePassword)
        CustomSpacerHeight(size = 16)

  /*      CustomRoundButton(
            text = context.getString(R.string.login),
            height = 48,
            width = 156,
            round = 18
        )*/

        Button(
            modifier = Modifier
                .height(48.dp)
                .width(156.dp)
                .fillMaxWidth(), onClick = {
                viewmodel.requestLogin(textStateUserId.value, textStatePassword.value)
                Log.e("data", textStateUserId.value.toString())
                Log.e("data", textStatePassword.value.toString())
            },
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = White,
                backgroundColor = BlueMedium
            )
        ) {
            Text(
                text = context.getString(R.string.login),
                style = MaterialTheme.typography.body2,
                color = White
            )
        }
        CustomSpacerHeight(size = 16)
        CustomTextHeader(
            text = context.getString(R.string.forget_pass),
            textStyle = MaterialTheme.typography.body1
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuth() {
    //LoginScreen()
    PharmaForceTheme() {
        LoginUiComponent()

    }
}