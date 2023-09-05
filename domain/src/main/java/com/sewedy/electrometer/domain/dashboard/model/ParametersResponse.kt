package com.sewedy.electrometer.domain.dashboard.model

data class ParametersResponse(
    val parameters: List<List<Parameter>>
)

data class Parameter(
    val id: Int,
    val serviceId: Int,
    val title: String,
    val titleAR: String?,
    val parameterName: String?,
    val validation: String?,
    val currency: String?,
    val type: Int?,
    val listField: String?,
    val billingAccount: Boolean?,
    val inputType: Int?,
    val min: Double?,
    val max: Double?,
    val isMandatory: Boolean?
)

