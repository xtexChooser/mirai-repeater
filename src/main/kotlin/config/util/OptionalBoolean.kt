package com.xtex.repeater.config.util

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OptionalBoolean(
    @SerialName("value")
    var value: Boolean? = null
) {

    companion object {

        val UNSET = OptionalBoolean(null)
        val TRUE = OptionalBoolean(true)
        val FALSE = OptionalBoolean(false)

    }

    fun getOrDefault(default: Boolean): Boolean {
        return if (value == null)
            default
        else
            value!!
    }

}