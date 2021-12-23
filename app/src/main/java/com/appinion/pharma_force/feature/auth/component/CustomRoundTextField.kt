package com.appinion.pharma_force.feature.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.ui.theme.BlueMedium
import com.appinion.pharma_force.ui.theme.OffWhite
import com.appinion.pharma_force.ui.theme.Transparent

@Composable
fun CustomRoundTextField(placeHolder: String, textState: MutableState<String>) {
    var passwordVisibility = remember { mutableStateOf(true) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp, 0.dp, 36.dp, 0.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = OffWhite,
            cursorColor = BlueMedium,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent
        ),

        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        shape = RoundedCornerShape(16.dp),
        placeholder = {
            Text(text = placeHolder, style = MaterialTheme.typography.body1)
        },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {

            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {
                //Icon(imageVector = image, "")
            }
        }
    )
}