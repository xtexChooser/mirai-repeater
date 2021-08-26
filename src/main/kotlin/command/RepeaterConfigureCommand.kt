package com.xtex.repeater.command

import com.xtex.repeater.Repeater
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.descriptor.buildCommandArgumentContext

object RepeaterConfigureCommand : CompositeCommand(
    Repeater, "repeater_configure",
    secondaryNames = arrayOf("rep_conf", "repconf"),
    description = "配置复读机",
    overrideContext = buildCommandArgumentContext {
        add(RepeaterScopedConfigArgumentParser)
    }
) {

    @SubCommand("repstart")
    @Description("开启全程复读")
    suspend fun CommandSender.repeaterStart(config: RepeaterScopedConfigArgument) {
        config.config.repeaterState = true
        sendMessage(
            "全程复读已启用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("repstop")
    @Description("关闭全程复读")
    suspend fun CommandSender.repeaterStop(config: RepeaterScopedConfigArgument) {
        config.config.repeaterState = false
        sendMessage(
            "全程复读已禁用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("repunset")
    @Description("重置全程复读开关状态")
    suspend fun CommandSender.repeaterUnset(config: RepeaterScopedConfigArgument) {
        config.config.repeaterState = null
        sendMessage(
            "全程复读已切换到未设置状态\n" +
                    config.clearCache()
        )
    }

    @SubCommand("chainstart")
    @Description("开启跟风复读")
    suspend fun CommandSender.chainStart(config: RepeaterScopedConfigArgument) {
        config.config.chainState = true
        sendMessage(
            "跟风复读已启用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("chainstop")
    @Description("关闭跟风复读")
    suspend fun CommandSender.chainStop(config: RepeaterScopedConfigArgument) {
        config.config.chainState = false
        sendMessage(
            "跟风复读已禁用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("chainunset")
    @Description("重置跟风复读开关状态")
    suspend fun CommandSender.chainUnset(config: RepeaterScopedConfigArgument) {
        config.config.chainState = null
        sendMessage(
            "跟风复读已切换到未设置状态\n" +
                    config.clearCache()
        )
    }

    @SubCommand("chainplaces")
    @Description("列出所有跟风复读位置")
    suspend fun CommandSender.chainPlaces(config: RepeaterScopedConfigArgument) {
        sendMessage("复读位于:(${config.config.chainPlaces.size}) ${config.config.chainPlaces.joinToString(", ")}")
    }

    @SubCommand("chainplaceadd")
    @Description("添加跟风复读位置")
    suspend fun CommandSender.chainPlaceAdd(config: RepeaterScopedConfigArgument, place: Int) {
        config.config.chainPlaces += place
        sendMessage(
            "已添加复读位置: $place\n" +
                    config.clearCache()
        )
    }

    @SubCommand("chainplaceremove")
    @Description("移除跟风复读位置")
    suspend fun CommandSender.chainPlaceRemove(config: RepeaterScopedConfigArgument, place: Int) {
        config.config.chainPlaces -= place
        sendMessage(
            "已移除复读位置: $place\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainstart")
    @Description("开启复读打断")
    suspend fun CommandSender.killChainStart(config: RepeaterScopedConfigArgument) {
        config.config.killChainState = true
        sendMessage(
            "复读打断已启用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainstop")
    @Description("关闭复读打断")
    suspend fun CommandSender.killChainStop(config: RepeaterScopedConfigArgument) {
        config.config.killChainState = false
        sendMessage(
            "复读打断已禁用\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainunset")
    @Description("重置复读打断开关状态")
    suspend fun CommandSender.killChainUnset(config: RepeaterScopedConfigArgument) {
        config.config.killChainState = null
        sendMessage(
            "复读打断已切换到未设置状态\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainat")
    @Description("查看复读打断位置")
    suspend fun CommandSender.killChainAt(config: RepeaterScopedConfigArgument) {
        sendMessage("复读打断${if (config.config.killChainState == null) "未设置" else if (config.config.killChainState!!) "已启用" else "已禁用"}， 于 ${config.config.killChainAt}")
    }

    @SubCommand("killchainat")
    @Description("设置复读打断位置")
    suspend fun CommandSender.killChainAt(config: RepeaterScopedConfigArgument, at: Int) {
        config.config.killChainAt = at
        sendMessage(
            "复读打断已设置于 ${config.config.killChainAt}\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainatunset")
    @Description("重置复读打断位置")
    suspend fun CommandSender.killChainAtUnset(config: RepeaterScopedConfigArgument) {
        config.config.killChainAt = null
        sendMessage(
            "复读打断位置已重置\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainwith")
    @Description("查看复读打断方式")
    suspend fun CommandSender.killChainWith(config: RepeaterScopedConfigArgument) {
        sendMessage("复读打断${if (config.config.killChainState == null) "未设置" else if (config.config.killChainState!!) "已启用" else "已禁用"}， 通过 ${config.config.killChainWith}")
    }

    @SubCommand("killchainwith")
    @Description("设置复读打断方式")
    suspend fun CommandSender.killChainWith(config: RepeaterScopedConfigArgument, with: String) {
        config.config.killChainWith = with
        sendMessage(
            "复读打断已设置为通过 ${config.config.killChainWith}\n" +
                    config.clearCache()
        )
    }

    @SubCommand("killchainwithunset")
    @Description("重置复读打断方式")
    suspend fun CommandSender.killChainWithUnset(config: RepeaterScopedConfigArgument) {
        config.config.killChainWith = null
        sendMessage(
            "复读打断方式已重置\n" +
                    config.clearCache()
        )
    }

}