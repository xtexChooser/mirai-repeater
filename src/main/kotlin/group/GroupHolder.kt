package com.xtex.repeater.group

import com.xtex.repeater.Repeater
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.contact.nameCardOrNick
import net.mamoe.mirai.message.data.MessageChain

data class GroupHolder(
    val group: Group,
    var lastMessage: String = "",
    var lastMessageCount: Int = 0
) {

    suspend fun onMessage(sender: Member, message: MessageChain) {
        // Global repeater
        if (Repeater.config.repeaterState) {
            group.sendMessage("${sender.nameCardOrNick}: ${message.contentToString()}")
        }
        // Chain repeater
        val thisMessage = message.contentToString()
        if (lastMessage == thisMessage) {
            lastMessageCount++
            if (lastMessageCount in Repeater.config.chainPlaces)
                group.sendMessage(message)
            // Chain killer
            if (lastMessageCount == Repeater.config.killChainAt)
                group.sendMessage(Repeater.config.killChainWith)
        } else {
            lastMessage = thisMessage
            lastMessageCount = 1
        }
    }

}
