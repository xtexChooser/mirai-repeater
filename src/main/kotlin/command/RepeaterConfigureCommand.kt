package com.xtex.repeater.command

import com.xtex.repeater.Repeater
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand

object RepeaterConfigureCommand : CompositeCommand(
    Repeater, "repeater_configure",
    secondaryNames = arrayOf("rep_conf", "repconf"), description = "配置复读机"
) {

    @SubCommand("repstart")
    @Description("开启全程复读")
    suspend fun CommandSender.repeaterStart() {
        Repeater.config.repeaterState = true
        Repeater.saveConfig()
        sendMessage("全程复读已启用")
    }

    @SubCommand("repstop")
    @Description("关闭全程复读")
    suspend fun CommandSender.repeaterStop() {
        Repeater.config.repeaterState = false
        Repeater.saveConfig()
        sendMessage("全程复读已禁用")
    }

    @SubCommand("chainstart")
    @Description("开启跟风复读")
    suspend fun CommandSender.chainStart() {
        Repeater.config.chainState = true
        Repeater.saveConfig()
        sendMessage("跟风复读已启用")
    }

    @SubCommand("chainstop")
    @Description("关闭跟风复读")
    suspend fun CommandSender.chainStop() {
        Repeater.config.chainState = false
        Repeater.saveConfig()
        sendMessage("跟风复读已禁用")
    }

    @SubCommand("chainplaces")
    @Description("列出所有跟风复读位置")
    suspend fun CommandSender.chainPlaces() {
        sendMessage("复读位于:(${Repeater.config.chainPlaces.size}) ${Repeater.config.chainPlaces.joinToString(", ")}")
    }

    @SubCommand("chainplaceadd")
    @Description("添加跟风复读位置")
    suspend fun CommandSender.chainPlaceAdd(place: Int) {
        Repeater.config.chainPlaces += place
        Repeater.saveConfig()
        sendMessage("已添加复读位置: $place")
    }

    @SubCommand("chainplaceremove")
    @Description("移除跟风复读位置")
    suspend fun CommandSender.chainPlaceRemove(place: Int) {
        Repeater.config.chainPlaces -= place
        Repeater.saveConfig()
        sendMessage("已移除复读位置: $place")
    }

    @SubCommand("killchainstart")
    @Description("开启复读打断")
    suspend fun CommandSender.killChainStart() {
        Repeater.config.killChainState = true
        Repeater.saveConfig()
        sendMessage("复读打断已启用")
    }

    @SubCommand("killchainstop")
    @Description("关闭复读打断")
    suspend fun CommandSender.killChainStop() {
        Repeater.config.killChainState = false
        Repeater.saveConfig()
        sendMessage("复读打断已禁用")
    }

    @SubCommand("killchainat")
    @Description("查看复读打断位置")
    suspend fun CommandSender.killChainAt() {
        sendMessage("复读打断${if (Repeater.config.killChainState) "已启用" else "已禁用"}， 于 ${Repeater.config.killChainAt}")
    }

    @SubCommand("killchainat")
    @Description("设置复读打断位置")
    suspend fun CommandSender.killChainAt(at: Int) {
        Repeater.config.killChainAt = at
        Repeater.saveConfig()
        sendMessage("复读打断已设置于 ${Repeater.config.killChainAt}")
    }

    @SubCommand("killchainwith")
    @Description("查看复读打断方式")
    suspend fun CommandSender.killChainWith() {
        sendMessage("复读打断${if (Repeater.config.killChainState) "已启用" else "已禁用"}， 通过 ${Repeater.config.killChainWith}")
    }

    @SubCommand("killchainwith")
    @Description("设置复读打断方式")
    suspend fun CommandSender.killChainWith(with: String) {
        Repeater.config.killChainWith = with
        Repeater.saveConfig()
        sendMessage("复读打断已设置通过 ${Repeater.config.killChainWith}")
    }

}