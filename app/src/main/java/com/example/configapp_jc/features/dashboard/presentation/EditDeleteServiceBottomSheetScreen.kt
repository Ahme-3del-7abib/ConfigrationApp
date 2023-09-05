package com.example.configapp_jc.features.dashboard.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.configapp_jc.R
import com.example.configapp_jc.features.dashboard.DashboardViewModel
import com.example.configapp_jc.utils.CommonRoundedButton
import com.sewedy.electrometer.domain.dashboard.model.Service

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun EditDeleteServiceBottomSheetScreen(
    item: Service?,
    bottomSheetState: ModalBottomSheetState,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            BottomSheetContent()
        }
    ) {

    }
}

@Composable
private fun BottomSheetContent() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 30.dp, horizontal = 20.dp)
            .background(Color.White)
    ) {
        val (deactivateBtn, updateBtn, deleteBtn) = createRefs()

        CommonRoundedButton(
            name = stringResource(R.string.deactivate_service),
            mainColor = R.color.petrol,
            textColor = R.color.white,
            modifier = Modifier
                .constrainAs(deactivateBtn) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
                .height(48.dp)
                .fillMaxWidth()
        ) {

        }

        CommonRoundedButton(
            name = stringResource(R.string.update_service),
            mainColor = R.color.petrol,
            textColor = R.color.white,
            modifier = Modifier
                .constrainAs(updateBtn) {
                    top.linkTo(deactivateBtn.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
                .height(48.dp)
                .fillMaxWidth()
        ) {

        }

        CommonRoundedButton(
            name = stringResource(R.string.delete_service),
            mainColor = R.color.petrol,
            textColor = R.color.white,
            modifier = Modifier
                .constrainAs(deleteBtn) {
                    top.linkTo(updateBtn.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
                .height(48.dp)
                .fillMaxWidth()
        ) {

        }
    }
}