package com.xtex.repeater.group

import com.xtex.repeater.config.RepeaterScopedConfig
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.contact.nameCardOrNick
import net.mamoe.mirai.message.data.MessageChain

data class GroupHolder(
    val group: Group,
    val config: RepeaterScopedConfig,
    @Suppress("SpellCheckingInspection")
    var lastMessageAsMiraiCode: String = "",
    var lastMessageCount: Int = 0
) {

    suspend fun onMessage(sender: Member, message: MessageChain) {
        // Global repeater
        if (config.repeaterState!!) {
            // @TODO: Check message type for image/voice message
            group.sendMessage("${sender.nameCardOrNick}: ${message.contentToString()}")
        }
        // Chain repeater
        val thisMessage = message.serializeToMiraiCode()
        if (lastMessageAsMiraiCode == thisMessage) {
            lastMessageCount++
            if (lastMessageCount in config.chainPlaces)
                group.sendMessage(message)
            // Chain killer
            if (lastMessageCount == config.killChainAt && config.killChainWith != null)
                group.sendMessage(config.killChainWith!!)
        } else {
            lastMessageAsMiraiCode = thisMessage
            lastMessageCount = 1
        }
    }

}
