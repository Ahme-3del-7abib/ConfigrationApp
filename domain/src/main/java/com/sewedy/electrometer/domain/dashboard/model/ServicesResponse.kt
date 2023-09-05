package com.sewedy.electrometer.domain.dashboard.model

data class ServicesResponse(
    val service: List<Service>
)

data class Service(
    val id: Int? = 0,
    val name: String,
    val nameAr: String?,
    val level: Int? = 0,
    val parentId: Int? = null,
    val isLeaf: Boolean,
    val logo: String?,
    val isInquirable: Boolean?,
    val requestType: String?,
    val paymentMethod: String?
)