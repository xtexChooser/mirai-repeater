package com.xtex.repeater.command

import com.xtex.repeater.config.RepeaterGeneralConfig
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.descriptor.AbstractCommandValueArgumentParser
import net.mamoe.mirai.console.command.getGroupOrNull

object RepeaterScopedConfigArgumentParser : AbstractCommandValueArgumentParser<RepeaterScopedConfigArgument>() {

    private const val GLOBAL = "global"
    private const val THIS = "this"

    override fun parse(raw: String, sender: CommandSender): RepeaterScopedConfigArgument {
        val group = sender.getGroupOrNull()
        return if (raw.equals(GLOBAL, true)) {
            RepeaterScopedConfigArgument(RepeaterGeneralConfig.root, null)
        } else if (group != null && raw.equals(THIS, true)) {
            RepeaterScopedConfigArgument(RepeaterGeneralConfig.byGroups[group.id]!!, group)
        } else {
            val id = raw.toLong()
            RepeaterScopedConfigArgument(RepeaterGeneralConfig.byGroups[id]!!, sender.bot!!.getGroup(id))
        }
    }

}