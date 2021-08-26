package com.xtex.repeater.command

import com.xtex.repeater.Repeater
import com.xtex.repeater.config.RepeaterScopedConfig
import net.mamoe.mirai.contact.Group

data class RepeaterScopedConfigArgument(
    val config: RepeaterScopedConfig,
    val group: Group?
) {

    fun clearCache(): String {
        return if (group !== null) {
            Repeater.groupHolders.remove(group)
            "已清除 ${group.id} 的复读追踪上下文"
        } else {
            Repeater.groupHolders.clear()
            "已清除全局复读追踪上下文"
        }
    }

}