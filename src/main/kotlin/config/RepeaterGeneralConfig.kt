package com.xtex.repeater.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value

object RepeaterGeneralConfig : AutoSavePluginConfig("General") {

    val root by value(RepeaterScopedConfig.DEFAULT_ROOT)

    val byGroups: MutableMap<Long, RepeaterScopedConfig> by value(mutableMapOf())

    fun getConfigForGroup(id: Long): RepeaterScopedConfig {
        if (id !in byGroups)
            byGroups[id] = RepeaterScopedConfig()
        return byGroups[id]!!.merge(root)
    }

}