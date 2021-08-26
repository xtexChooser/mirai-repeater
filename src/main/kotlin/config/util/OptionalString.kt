package com.xtex.repeater.config.util

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OptionalString(
    @SerialName("value")
    var value: String? = null
) {

    companion object {

        val UNSET = OptionalString(null)

    }

    fun getOrDefault(default: String): String {
        return if (value == null)
            default
        else
            value!!
    }

}
