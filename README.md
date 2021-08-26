# Repeater: Mirai复读机插件

## 功能

- 全程复读：每一句话都复读一次
- 跟风复读：其他人复读时在指定位置复读
- 复读打断：自动打断施法

## 命令

所有命令以`repeater_configure`（或`rep_conf`/`repconf`）开头

- /repeater_configure chainplaceadd <位置: Int>  # 添加跟风复读位置

- /repeater_configure chainplaceremove <位置: Int>  # 移除跟风复读位置

- /repeater_configure chainplaces  # 列出所有跟风复读位置

- /repeater_configure chainstart  # 开启跟风复读

- /repeater_configure chainstop  # 关闭跟风复读

- /repeater_configure killchainat  # 查看复读打断位置

- /repeater_configure killchainat <位置: Int>  # 设置复读打断位置

- /repeater_configure killchainstart  # 开启复读打断

- /repeater_configure killchainstop  # 关闭复读打断

- /repeater_configure killchainwith  # 查看复读打断方式

- /repeater_configure killchainwith <语句: String>  # 设置复读打断方式

- /repeater_configure repstart  # 开启全程复读

- /repeater_configure repstop  # 关闭全程复读

## Tip

- 仅对群聊有效
- 对Bot自身发出的消息无效，计数器也不会计算

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

