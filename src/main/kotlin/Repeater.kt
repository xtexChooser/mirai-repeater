package com.xtex.repeater

import com.google.gson.GsonBuilder
import com.xtex.repeater.command.RepeaterConfigureCommand
import com.xtex.repeater.config.RepeaterConfig
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.nameCardOrNick
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

    private val configFile = resolveConfigFile("Configuration.json")
    private val configGson = GsonBuilder()
        .serializeNulls()
        .setLenient()
        .setPrettyPrinting()
        .create()
    val config = loadConfig()
    private var lastMessage = ""
    private var lastMessageCount = 0

    override fun onEnable() {
        CommandManager.registerCommand(RepeaterConfigureCommand, false);
        GlobalEventChannel.subscribeGroupMessages(priority = EventPriority.LOW,
            listeners = {
                always {
                    // Global repeater
                    if (config.repeaterState) {
                        group.sendMessage("${sender.nameCardOrNick}: ${message.contentToString()}")
                    }
                    // Chain repeater
                    val thisMessage = message.contentToString()
                    if (lastMessage == thisMessage) {
                        lastMessageCount++
                        if (lastMessageCount in config.chainPlaces)
                            group.sendMessage(message)
                        // Chain killer
                        if (lastMessageCount == config.killChainAt)
                            group.sendMessage(config.killChainWith)
                    } else {
                        lastMessage = thisMessage
                        lastMessageCount = 1
                    }
                }
            })
    }

    override fun onDisable() {
        saveConfig()
    }

    private fun loadConfig(): RepeaterConfig {
        if (!configFile.exists())
            return RepeaterConfig()
        return configGson.fromJson(configFile.readText(), RepeaterConfig::class.java)
    }

    fun saveConfig() {
        configFile.writeText(configGson.toJson(config))
    }

}