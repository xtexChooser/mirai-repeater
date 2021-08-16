package com.xtex.repeater.config

import com.google.gson.annotations.SerializedName

class RepeaterConfig {

    @SerializedName("repeater_state")
    var repeaterState = false

    @SerializedName("chain_state")
    var chainState = false

    @SerializedName("chain_places")
    var chainPlaces = arrayListOf<Int>()

    @SerializedName("kill_chain_state")
    var killChainState = false

    @SerializedName("kill_chain_at")
    var killChainAt = 0

    @SerializedName("kill_chain_with")
    var killChainWith = "打断施法"

}