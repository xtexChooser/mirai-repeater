package com.xtex.repeater

import com.xtex.repeater.command.RepeaterConfigureCommand
import com.xtex.repeater.config.RepeaterGeneralConfig
import com.xtex.repeater.group.GroupHolder
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.event.EventPriority
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.subscribeGroupMessages

object Repeater : KotlinPlugin(
    JvmPluginDescription(
        id = "com.xtex.repeater",
        name = "Repeater",
        version = Repeater::class.java.`package`.implementationVersion,
    ) {
        author("xtexChooser")
    }
) {

    val groupHolders = mutableMapOf<Group, GroupHolder>()
        .withDefault { group -> GroupHolder(group, RepeaterGeneralConfig.getConfigForGroup(group.id)) }

    override fun onEnable() {
        RepeaterGeneralConfig.reload()
        CommandManager.registerCommand(RepeaterConfigureCommand, false);
        GlobalEventChannel.subscribeGroupMessages(priority = EventPriority.LOW,
            listeners = {
                always {
                    groupHolders[group]!!.onMessage(sender, message)
                }
            })
    }

}