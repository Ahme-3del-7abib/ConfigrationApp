package com.example.configapp_jc.features.dashboard.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.configapp_jc.R
import com.example.configapp_jc.features.dashboard.DashboardViewModel
import com.example.configapp_jc.utils.CommonOutLineTextField

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun AddServicesBottomSheetScreen(
    bottomSheetState: ModalBottomSheetState, viewModel: DashboardViewModel = hiltViewModel()
) {

    ModalBottomSheetLayout(sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            AddServicesBottomSheetContent()
        }) {

    }
}

@Composable
fun AddServicesBottomSheetContent() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        val (addServicesTV, servNameEnED, servNameArED) = createRefs()

        Text(text = stringResource(R.string.add_service),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = colorResource(id = R.color.petrol),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(addServicesTV) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        CommonOutLineTextField(
            input = "",
            hint = stringResource(R.string.service_en),
            placeHolder = stringResource(R.string.enter_name),
            inputType = KeyboardType.Text,
            modifier = Modifier.constrainAs(servNameEnED) {
                top.linkTo(addServicesTV.bottom, margin = 18.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        CommonOutLineTextField(
            input = "",
            hint = stringResource(R.string.service_name_ar),
            placeHolder = stringResource(R.string.enter_name),
            inputType = KeyboardType.Text,
            modifier = Modifier.constrainAs(servNameArED) {
                top.linkTo(servNameEnED.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}