package com.example.configapp_jc.features.dashboard.presentation

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.configapp_jc.R
import com.example.configapp_jc.features.dashboard.DashboardViewModel
import com.example.configapp_jc.utils.CircleProgressBar
import com.example.configapp_jc.utils.CommonRoundedButton
import com.example.configapp_jc.utils.CommonTextView
import com.sewedy.electrometer.domain.dashboard.model.Service
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun DashboardScreen(context: Context, viewModel: DashboardViewModel = hiltViewModel()) {

    val scope = rememberCoroutineScope()
    val allServices by remember { mutableStateOf(viewModel.getAllServices.value) }

    val isLoading = allServices.isLoading
    val error = allServices.error?.errorMessage?.getMessage(context)

    val editDeleteBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val addServiceBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = stringResource(R.string.all_services),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = colorResource(id = R.color.petrol),
            modifier = Modifier
                .padding(top = 6.dp, start = 6.dp)
                .align(Alignment.TopStart)
        )

        GridList(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(top = 70.dp, bottom = 70.dp),
            itemsList = allServices.allServices
        ) {
            scope.launch {
                viewModel.setCurrentService(it)
                editDeleteBottomSheetState.show()
            }
        }

        CommonRoundedButton(
            name = stringResource(id = R.string.add_service),
            mainColor = R.color.petrol,
            textColor = R.color.white,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .align(Alignment.BottomCenter)
        ) {
            scope.launch {
                addServiceBottomSheetState.show()
            }
        }

        when {
            error.orEmpty().isNotBlank() -> {
                CommonTextView(
                    text = error.orEmpty(),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            }

            isLoading -> {
                CircleProgressBar(
                    Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }

            allServices.allServices.isEmpty() -> {
                CommonTextView(
                    text = stringResource(R.string.no_data_found),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            }
        }
    }

    EditDeleteServiceBottomSheetScreen(
        viewModel.currentService.value,
        bottomSheetState = editDeleteBottomSheetState,
    )

    AddServicesBottomSheetScreen(bottomSheetState = addServiceBottomSheetState)
}

@Composable
fun GridList(
    modifier: Modifier = Modifier, itemsList: List<Service>, onItemClicked: (Service) -> Unit
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier, content = {
        items(items = itemsList) { item ->
            ServicesItemList(item, onItemClicked)
        }
    })
}

@Composable
fun ServicesItemList(item: Service, onItemClicked: (Service) -> Unit) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .height(130.dp)
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
            .clickable { onItemClicked(item) },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.petrol)),
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}