package com.xtex.repeater.config

import kotlinx.serialization.Serializable

@Serializable
data class RepeaterScopedConfig(
    var repeaterState: Boolean? = null,
    var chainState: Boolean? = null,
    var chainPlaces: MutableList<Int> = mutableListOf(),
    var killChainState: Boolean? = null,
    var killChainAt: Int? = null,
    var killChainWith: String? = null
) {

    companion object {

        val DEFAULT_ROOT = RepeaterScopedConfig(
            repeaterState = false,
            chainState = false,
            killChainState = false,
            killChainAt = 0,
            killChainWith = "打断施法"
        )

        private fun mixEnableState(a: Boolean?, b: Boolean?): Boolean {
            return !(a == false || b == false)
        }

    }

    fun merge(config: RepeaterScopedConfig): RepeaterScopedConfig {
        return RepeaterScopedConfig(
            repeaterState = mixEnableState(this.repeaterState, config.repeaterState),
            chainState = mixEnableState(this.chainState, config.chainState),
            chainPlaces = (config.chainPlaces + this.chainPlaces).toMutableList(),
            killChainState = mixEnableState(this.killChainState, config.killChainState),
            killChainAt = if (this.killChainAt != null) this.killChainAt else config.killChainAt,
            killChainWith = if (this.killChainWith != null) this.killChainWith else config.killChainWith,
        )
    }

}