package com.xtex.repeater

import com.google.gson.GsonBuilder
import com.xtex.repeater.command.RepeaterConfigureCommand
import com.xtex.repeater.config.RepeaterConfig
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

    private val configFile = resolveConfigFile("Configuration.json")
    private val configGson = GsonBuilder()
        .serializeNulls()
        .setLenient()
        .setPrettyPrinting()
        .create()
    val config = loadConfig()
    private val groupHolders = HashMap<Group, GroupHolder>()

    override fun onEnable() {
        CommandManager.registerCommand(RepeaterConfigureCommand, false);
        GlobalEventChannel.subscribeGroupMessages(priority = EventPriority.LOW,
            listeners = {
                always {
                    getGroupHolder(group).onMessage(sender, message)
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

    private fun getGroupHolder(group: Group): GroupHolder {
        if (group !in groupHolders)
            groupHolders[group] = GroupHolder(group)
        return groupHolders[group]!!
    }

}