package com.sewedy.electrometer.core

import android.content.Context

data class UserMessage(
    private val resMessage: Int? = null,
    private val strMessage: String? = null
) {
    fun getMessage(context: Context): String {
        return if (resMessage != null) {
            context.getString(resMessage)
        } else {
            strMessage ?: "Auth error happened, please logout and login agan!"
        }
    }
}