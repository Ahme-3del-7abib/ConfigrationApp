package com.sewedy.electrometer.data.dashboard.repo

import com.sewedy.electrometer.core.remote.APIResult
import com.sewedy.electrometer.core.remote.BaseRemoteDataSource
import com.sewedy.electrometer.data.dashboard.remote.AllServicesApi
import com.sewedy.electrometer.domain.dashboard.model.Parameter
import com.sewedy.electrometer.domain.dashboard.model.ParametersResponse
import com.sewedy.electrometer.domain.dashboard.model.Service
import com.sewedy.electrometer.domain.dashboard.model.ServicesResponse
import com.sewedy.electrometer.domain.dashboard.repo.IAllServicesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AllServicesRepo(
    private val allServicesApi: AllServicesApi
) : IAllServicesRepo, BaseRemoteDataSource() {

    private val education = Service(
        1,
        "Education",
        "التعليم",
        0,
        null,
        false,
        "0",
        true,
        "",
        ""
    )

    private val egyptianELearning = Service(
        2,
        "Egyptian E-Learning Education",
        "",
        1,
        1,
        true,
        "",
        true,
        "",
        ""
    )

    private val ministryOfEducation = Service(
        3,
        "Ministry Of Education",
        "",
        1,
        1,
        true,
        "",
        true,
        "",
        ""
    )

    private val payStudentFees = Service(
        4,
        "Pay Student Fees",
        "",
        2,
        3,
        true,
        "",
        true,
        "",
        ""
    )

    private val tulFees = Service(
        5,
        "Tuition Fees",
        "",
        2,
        3,
        true,
        "",
        true,
        "",
        ""
    )

    private val telecom = Service(
        6,
        "Telecom & internet bills",
        "",
        0,
        null,
        false,
        "",
        true,
        "",
        ""
    )

    private val vodafone = Service(
        7,
        "Vodafone",
        "فودافون",
        1,
        6,
        true,
        "",
        true,
        "",
        ""
    )

    private val vodafoneBills = Service(
        8,
        "Vodafone Bill",
        "فواتير فودافون",
        2,
        7,
        true,
        "",
        true,
        "",
        ""
    )

    private val vodafoneADSL = Service(
        9,
        "Vodafone ADSL",
        "انترنت فودافون",
        2,
        7,
        true,
        "",
        true,
        "",
        ""
    )

    private val we = Service(
        10,
        "We",
        "وي",
        1,
        6,
        true,
        "",
        true,
        "",
        ""
    )

    private val weInterNetInvoice = Service(
        11,
        "We home internet invoice",
        "",
        2,
        10,
        true,
        "",
        true,
        "",
        ""
    )

    private val we20GB = Service(
        12,
        "20 GB Telecom egypt",
        "وي",
        2,
        10,
        true,
        "",
        true,
        "",
        ""
    )

    private val orange = Service(
        13,
        "Orange",
        "أورانج",
        1,
        6,
        true,
        "",
        true,
        "",
        ""
    )

    override fun getAllServices(): Flow<APIResult<ServicesResponse>> {
        return flowOf(
            APIResult.Success(
                ServicesResponse(
                    arrayListOf(
                        education,
                        ministryOfEducation,
                        tulFees,
                        payStudentFees,
                        tulFees,
                        egyptianELearning,
                        telecom,
                        orange,
                        vodafone,
                        we,
                        weInterNetInvoice,
                        we20GB,
                        vodafoneBills,
                        vodafoneADSL
                    )
                )
            )
        )
    }

    private val payStudentFeesParams = listOf(
        Parameter(
            id = 1,
            serviceId = 4,
            title = "Pay student fees",
            titleAR = "دفع فواتير الطالب",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 4,
            title = "National ID",
            titleAR = "الرقم القومي",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 1,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val tulFeesParams = listOf(
        Parameter(
            id = 1,
            serviceId = 5,
            title = "Tuition Fees",
            titleAR = "رسـوم الطالب",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 5,
            title = "National ID",
            titleAR = "الرقم القومي",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 1,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val vodafoneBillsParams = listOf(
        Parameter(
            id = 1,
            serviceId = 8,
            title = "Vodafone Bill",
            titleAR = "فواتير فودافون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 8,
            title = "Mobile Number",
            titleAR = "رقم التليفون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 5,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val vodafoneADSLParams = listOf(
        Parameter(
            id = 1,
            serviceId = 9,
            title = "Vodafone ADSL",
            titleAR = "أنترنت فودافون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 9,
            title = "Phone Number",
            titleAR = "رقم التليفون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 5,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val weInterNetInvoiceParams = listOf(
        Parameter(
            id = 1,
            serviceId = 11,
            title = "WE-Home Internet Invoice",
            titleAR = "فاتورة الإنترنت للمنزل من WE",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 11,
            title = "Phone Number",
            titleAR = "رقم التليفون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 5,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val we20GBParams = listOf(
        Parameter(
            id = 1,
            serviceId = 12,
            title = "20 GB - Telecom egypt",
            titleAR = "20 جيجا - المصرية للاتصالات",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 12,
            title = "Mobile Number",
            titleAR = "رقم التليفون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 5,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    private val orangeParams = listOf(
        Parameter(
            id = 1,
            serviceId = 12,
            title = "Orange Bill",
            titleAR = "أورانج بيل",
            parameterName = "",
            validation = null,
            currency = "",
            type = 0,
            listField = "",
            billingAccount = null,
            inputType = null,
            min = null,
            max = null,
            isMandatory = false
        ),
        Parameter(
            id = 1,
            serviceId = 12,
            title = "Mobile Number",
            titleAR = "رقم التليفون",
            parameterName = "",
            validation = null,
            currency = "",
            type = 2,
            listField = "",
            billingAccount = true,
            inputType = 5,
            min = null,
            max = null,
            isMandatory = true
        )
    )

    override fun getAllParameters(): Flow<APIResult<ParametersResponse>> {
        return flowOf(
            APIResult.Success(
                ParametersResponse(
                    listOf(
                        payStudentFeesParams,
                        tulFeesParams,
                        vodafoneBillsParams,
                        vodafoneADSLParams,
                        weInterNetInvoiceParams,
                        we20GBParams,
                        orangeParams
                    )
                )
            )
        )
    }

//     override fun getAllServices(): Flow<APIResult<ServicesResponse>> = safeApiCall {
//        allServicesApi.getAllServices()
//     }
}