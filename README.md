# Repeater: Mirai复读机插件

## 功能

- 全程复读：每一句话都复读一次
- 跟风复读：其他人复读时在指定位置复读
- 复读打断：自动打断施法

## 命令

所有命令以`repeater_configure`（或`rep_conf`/`repconf`）开头

- /repeater_configure repstart <配置上下文>   # 开启全程复读
- /repeater_configure repstop <配置上下文>   # 关闭全程复读
- /repeater_configure repunset <配置上下文>   # 重置全程复读开关状态
- /repeater_configure chainstart <配置上下文>   # 开启跟风复读
- /repeater_configure chainstop <配置上下文>   # 关闭跟风复读
- /repeater_configure chainunset <配置上下文>   # 重置跟风复读开关状态
- /repeater_configure chainplaces <配置上下文>   # 列出所有跟风复读位置
- /repeater_configure chainplaceadd <配置上下文> <位置: Int>  # 添加跟风复读位置
- /repeater_configure chainplaceremove <配置上下文>  <位置: Int>  # 移除跟风复读位置
- /repeater_configure killchainstart <配置上下文>   # 开启复读打断
- /repeater_configure killchainstop <配置上下文>   # 关闭复读打断
- /repeater_configure killchainunset <配置上下文>   # 重置复读打断开关状态
- /repeater_configure killchainat <配置上下文>   # 查看复读打断位置
- /repeater_configure killchainat <配置上下文>  <位置: Int>  # 设置复读打断位置
- /repeater_configure killchainatunset <配置上下文>   # 重置复读打断位置
- /repeater_configure killchainwith <配置上下文>   # 查看复读打断方式
- /repeater_configure killchainwith <配置上下文>  <语句: String>  # 设置复读打断方式
- /repeater_configure killchainwithunset <配置上下文>   重置复读打断方式

### 配置上下文

配置上下文 可以直接是一个QQ群的群号，也可以用`global`选择全局配置或`this`选中本群（仅通过群聊控制时有效）。

## Tip

- 仅对群聊有效。

- 对Bot自身发出的消息无效，计数器也不会计算。

- 复读位置为0时不会生效、

- 所有参数重置后会进入`UNSET`状态并使用全局状态，跟随全局状态变更。

  全局参数重置后，开关状态的效果与打开一样，但位置重置后，效果与0一样，不会生效，复读打断方式重置后也不会生效（指相当于功能关闭）。

## LICENSE

```
Mirai-Repeater: repeater for mirai
Copyright (C) 2021 xtexChooser

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
```

