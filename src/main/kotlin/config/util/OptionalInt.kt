package com.xtex.repeater.config.util

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OptionalInt(
    @SerialName("value")
    var value: Int? = null
) {

    companion object {

        val UNSET = OptionalInt(null)

    }

    fun getOrDefault(default: Int): Int {
        return if (value == null)
            default
        else
            value!!
    }

}