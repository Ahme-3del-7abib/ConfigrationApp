@file:OptIn(ExperimentalMaterialApi::class)

package com.example.configapp_jc.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configapp_jc.R


@Composable
fun CommonTextView(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        modifier = modifier,
        textAlign = TextAlign.Center,
        color = Color.Gray
    )
}

@Composable
fun CircleProgressBar(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = colorResource(id = R.color.petrol),
        strokeWidth = Dp(value = 4F)
    )
}

@Composable
fun CommonRoundedButton(
    modifier: Modifier = Modifier, name: String, mainColor: Int, textColor: Int, onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        shape = RoundedCornerShape(18.dp),
        modifier = modifier.clip(RoundedCornerShape(16.dp)),
        border = BorderStroke(1.dp, colorResource(id = mainColor)),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = textColor),
            backgroundColor = colorResource(id = mainColor)
        )
    ) {
        Text(
            text = name,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CommonOutLineTextField(
    input: String,
    hint: String,
    placeHolder: String,
    inputType: KeyboardType,
    modifier: Modifier = Modifier
) {
    var text = input
    OutlinedTextField(
        value = text,
        label = { Text(text = hint, fontSize = 14.sp) },
        placeholder = { Text(text = placeHolder) },
        onValueChange = { text = it },
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = outlinedTextFieldColors(
            textColor = colorResource(id = R.color.petrol),
            cursorColor = colorResource(id = R.color.petrol),
            errorBorderColor = colorResource(id = R.color.red),
            focusedBorderColor = colorResource(id = R.color.petrol),
            unfocusedBorderColor = colorResource(id = R.color.petrol)
        )
    )
}

@Composable
fun CommonTextFieldWithIcons(
    input: String,
    hint: String,
    placeHolder: String,
    inputType: KeyboardType,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    var text = input
    OutlinedTextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        leadingIcon = { Icon(imageVector = icon, contentDescription = "") },
        onValueChange = { text = it },
        placeholder = { Text(text = placeHolder) },
        label = { Text(text = hint, fontSize = 14.sp) },
        modifier = modifier.fillMaxWidth(),
        colors = outlinedTextFieldColors(
            textColor = colorResource(id = R.color.petrol),
            cursorColor = colorResource(id = R.color.petrol),
            errorBorderColor = colorResource(id = R.color.red),
            focusedBorderColor = colorResource(id = R.color.petrol),
            unfocusedBorderColor = colorResource(id = R.color.petrol)
        )
    )
}